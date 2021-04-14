package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import roomie.models.landlord.Landlord;
import roomie.services.LandlordService;

import javax.validation.Valid;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/landlords")
public class LandlordController {
	@Autowired
	private LandlordService landlordService;
	
	@PostMapping
	public Landlord register(@Valid @RequestBody Landlord landlord) throws PersistentException {
		return landlordService.register(landlord);
	}
	
}
