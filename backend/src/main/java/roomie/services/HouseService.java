package roomie.services;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 15:24
 */

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.helpers.UserUtils;
import roomie.models.auth.UpdatePasswordRequest;
import roomie.models.photo.Photo;
import roomie.models.photo.PhotoDAO;
import roomie.models.house.House;
import roomie.models.house.HouseDAO;

import java.util.ArrayList;
import java.util.List;

@Service
public class HouseService {

    //@Autowired
    //private UserUtils userUtils;

    private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public House register(House house, List<Photo> photos) throws PersistentException {
        if (photos == null) {
            Photo single_photo = PhotoDAO.createPhoto();
            PhotoDAO.save(single_photo);
            photos = new ArrayList<>();
            photos.add(single_photo);
        }
        for(Photo p: photos)
            house.photos.add(p);
        HouseDAO.save(house);
        return house;
    }

    /*public House getById(int id) throws ResourceNotFoundException, PersistentException {
        House house = HouseDAO.getHouseByORMID(id);
        if (house == null) {
            throw new ResourceNotFoundException("House not found: id=" + id);
        }
        return house;
    }*/

    public boolean delete(House house) throws PersistentException, ResourceNotFoundException {
        HouseDAO.evict(house);
        return HouseDAO.delete(house);
    }

    /*public House update(House house, House houseInfo) throws PersistentException {
        if (houseInfo.getName() != null) {
            house.setName(houseInfo.getName());
        }

        if (houseInfo.getUsername() != null) {
            house.setUsername(houseInfo.getUsername());
        }

        if (houseInfo.getPhone() != null) {
            house.setPhone(houseInfo.getPhone());
        }

        if (houseInfo.getSex() != null) {
            house.setSex(houseInfo.getSex());
        }

        if (houseInfo.getAddress() != null) {
            house.setAddress(houseInfo.getAddress());
        }

        HouseDAO.save(house);
        HouseDAO.refresh(house);
        return house;
    }

    public boolean updatePassword(House house, UpdatePasswordRequest body) throws PersistentException {
        if (!passwordEncoder.matches(body.getOldPassword(), house.getPassword())) {
            throw new ErrorDetails("Current password is not correct");
        }

        if (body.getOldPassword().equals(body.getNewPassword())) {
            throw new ErrorDetails("Current and new passwords can't be the same");
        }

        house.setPassword(passwordEncoder.encode(body.getNewPassword()));

        HouseDAO.save(house);
        HouseDAO.refresh(house);
        return true;
    }*/

}
