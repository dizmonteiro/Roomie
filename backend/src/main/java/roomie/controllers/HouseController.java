package roomie.controllers;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import roomie.exception.ResourceNotFoundException;
import roomie.models.auth.UpdatePasswordRequest;
import roomie.models.landlord.Landlord;
import roomie.models.photo.Photo;
import roomie.models.house.House;
import roomie.models.landlord.LandlordDAO;
import roomie.services.PhotoService;
import roomie.services.HouseService;

import javax.validation.Valid;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
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
    private PhotoService photoService;

    @PostMapping(consumes = {"multipart/form-data"})
    public House register(@Valid House house, @RequestPart(value = "file", required = false) MultipartFile[] files) throws PersistentException {

        List<Photo> photos = new ArrayList<>();
        if(files != null) {
            Arrays.stream(files).forEach(file -> {
                try {
                    Photo photo = photoService.store(file);
                    photos.add(photo);
                } catch (PersistentException e) {
                    e.printStackTrace();
                }

            });
        }
        Landlord l = LandlordDAO.loadLandlordByORMID(2);
        l.houses.add(house);
        return houseService.register(house, photos);
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
