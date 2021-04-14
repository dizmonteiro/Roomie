package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.avatar.Avatar;
import roomie.models.landlord.Landlord;
import roomie.services.AvatarService;
import roomie.services.LandlordService;

import javax.validation.Valid;
import java.io.IOException;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 10:00
 */

@RestController
@RequestMapping("/landlords")
public class LandlordController {
	@Autowired
	private LandlordService landlordService;
	
	@Autowired
	private AvatarService avatarService;
	
	@PostMapping(consumes = {"multipart/form-data"})
	public Landlord register(@Valid Landlord landlord, @RequestPart MultipartFile file) throws PersistentException {
		Avatar avatar = avatarService.store(file);
		return landlordService.register(landlord, avatar);
	}
	
	@GetMapping(value = "/{id}")
	public Landlord getLandlord(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return landlordService.getById(id);
	}
	
	@GetMapping(value = "/{id}/avatar", produces = "image/*")
	@ResponseBody
	public byte[] getAvatar(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
		return avatarService.load(landlordService.getById(id).getAvatar());
	}
	
}
