package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.auth.MyUser;
import roomie.models.house.House;
import roomie.models.landlord.Landlord;
import roomie.models.photo.Photo;
import roomie.services.HouseService;
import roomie.services.LandlordService;
import roomie.services.PhotoService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 16:03
 */

@RestController
@RequestMapping("/houses")
public class HouseController {
	@Autowired
	private HouseService houseService;
	
	@Autowired
	private LandlordService landlordService;
	
	@Autowired
	private PhotoService photoService;
	
	@PreAuthorize("hasRole('LANDLORD')")
	@PostMapping(consumes = {"multipart/form-data"})
	public House register(@Valid House house, @RequestPart(value = "files", required = false) MultipartFile[] files, Authentication auth) throws PersistentException, ResourceNotFoundException {
		Landlord landlord = landlordService.getById(((MyUser) auth.getPrincipal()).getId());
		
		List<Photo> photos = new ArrayList<>();
		if (files != null) {
			for (MultipartFile file : files) {
				Photo photo = photoService.store(file);
				photos.add(photo);
			}
		} else {
			Photo photo = photoService.store(null);
			photos.add(photo);
		}
		
		landlord.houses.add(house);
		houseService.register(house, photos);
		landlordService.save(landlord);
		return house;
	}
	
	@PreAuthorize("hasRole('LANDLORD')")
	@GetMapping(value = "/{id}")
	public House getHouse(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return houseService.getById(id);
	}
	
	@PreAuthorize("hasRole('LANDLORD')")
	@GetMapping(value = "/{id}/photos")
	public List<Integer> getHousePhotos(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return houseService.getById(id).getPhotos();
	}
	
	
	@GetMapping(value = "/photos/{id}", produces = "image/*")
	@ResponseBody
	public byte[] getPhoto(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
		return photoService.load(photoService.getById(id));
	}
	
}
