package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
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

    /*@GetMapping(value = "/{id}")
    public House getHouse(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
        return houseService.getById(id);
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @PutMapping("/{id}/password")
    public ResponseEntity<String> updatePassword(@PathVariable int id, @Valid @RequestBody UpdatePasswordRequest body) throws PersistentException, ResourceNotFoundException {
        House house = houseService.getById(id);
        boolean res = houseService.updatePassword(house, body);
        if (res) {
            return ResponseEntity.ok("Password updated successfully");
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @PutMapping(value = "/{id}")
    public House editLandord(@PathVariable int id, House houseInfo, @RequestPart(value = "file", required = false) MultipartFile file) throws PersistentException, ResourceNotFoundException {
        House house = houseService.getById(id);
        house = houseService.update(house, houseInfo);
        photoService.update(house.getPhoto(), file);
        return house;
    }

    @PreAuthorize("hasRole('LANDLORD') and @userSecurity.isSelf(authentication,#id)")
    @DeleteMapping(value = "/{id}")
    public ResponseEntity<Void> deleteHouse(@PathVariable int id) throws PersistentException, ResourceNotFoundException {
        House house = houseService.getById(id);
        photoService.delete(house.getPhoto());
        boolean res = houseService.delete(house);
        if (res) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping(value = "/{id}/photo", produces = "image/*")
    @ResponseBody
    public byte[] getPhoto(@PathVariable int id) throws PersistentException, ResourceNotFoundException, IOException {
        return photoService.load(houseService.getById(id).getPhoto());
    }
*/
}
