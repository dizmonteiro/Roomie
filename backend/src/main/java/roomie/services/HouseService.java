package roomie.services;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 15:24
 */

import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ResourceNotFoundException;
import roomie.models.house.House;
import roomie.models.house.HouseDAO;
import roomie.models.photo.Photo;

import java.util.List;

@Service
public class HouseService {
	public House register(House house, List<Photo> photos) throws PersistentException {
		for (Photo p : photos) {
			house.photos.add(p);
		}
		HouseDAO.save(house);
		return house;
	}
	
	public House getById(int id) throws ResourceNotFoundException, PersistentException {
		House house = HouseDAO.getHouseByORMID(id);
		if (house == null) {
			throw new ResourceNotFoundException("House not found: id=" + id);
		}
		return house;
	}
	
	public boolean delete(House house) throws PersistentException, ResourceNotFoundException {
		HouseDAO.evict(house);
		return HouseDAO.delete(house);
	}
	
}
