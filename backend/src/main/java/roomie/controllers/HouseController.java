package roomie.controllers;

import io.swagger.v3.oas.annotations.Parameter;
import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
		
		houseService.register(house, landlord, photos);
		return house;
	}
	
	@GetMapping()
	@Parameter(name = "limit", description = "Number of items per page")
	@Parameter(name = "offset", description = "Index of first item in page")
	public List<House> getHouses(@RequestParam(required = false) String title, @RequestParam(required = false) Integer rooms, @RequestParam(required = false) Double price, @RequestParam(required = false, defaultValue = "10") Integer limit, @RequestParam(required = false, defaultValue = "0") Integer offset) throws PersistentException, ResourceNotFoundException {
		return houseService.filter(title, rooms, price, limit, offset);
	}
	
	@GetMapping(("/total"))
	public Integer getTotalHouses() throws PersistentException, ResourceNotFoundException {
		return houseService.getTotalHouses();
	}
	
	@GetMapping(value = "/{id}")
	public House getHouse(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return houseService.getById(id);
	}
	
	@GetMapping(value = "/{id}/photos")
	public List<Integer> getHousePhotos(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		return houseService.getById(id).getPhotos();
	}
	
	@PreAuthorize("hasRole('LANDLORD') and @userSecurity.isOwner(authentication,#id)")
	@PutMapping(value = "/{id}")
	public House editHouse(@PathVariable int id, House houseInfo, @RequestPart(value = "files", required = false) MultipartFile[] files) throws PersistentException, ResourceNotFoundException {
		House house = houseService.getById(id);
		List<Photo> photos = new ArrayList<>();
		
		if (files != null) {
			for (Photo p : house.photos.toArray()) {
				photoService.delete(p);
			}
			house.photos.clear();
			
			for (MultipartFile file : files) {
				Photo photo = photoService.store(file);
				photos.add(photo);
			}
		}
		
		house = houseService.update(house, houseInfo, photos);
		return house;
	}
	
	@PreAuthorize("hasRole('LANDLORD') and @userSecurity.isOwner(authentication, #id)")
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> deleteHouse(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
		House house = houseService.getById(id);
		for (Photo p : house.photos.toArray()) {
			photoService.delete(p);
		}
		boolean res = houseService.delete(house);
		if (res) {
			return ResponseEntity.noContent().build();
		} else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
		}
	}
	
	@GetMapping(value = "/photos/{id}", produces = "image/*")
	@ResponseBody
	public byte[] getPhoto(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
		return photoService.load(photoService.getById(id));
	}
	
}
