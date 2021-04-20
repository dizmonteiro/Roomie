package roomie.services;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 15:24
 */

import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.springframework.stereotype.Service;
import roomie.exception.ResourceNotFoundException;
import roomie.models.house.House;
import roomie.models.house.HouseDAO;
import roomie.models.landlord.Landlord;
import roomie.models.photo.Photo;
import roomie.repositories.house.HouseCriteria;

import java.util.List;

@Service
public class HouseService {
	public House register(House house, Landlord landlord, List<Photo> photos) throws PersistentException {
		for (Photo p : photos) {
			house.photos.add(p);
		}
		house.setLandlord(landlord);
		HouseDAO.save(house);
		return house;
	}
	
	public List<House> filter(String title, Integer rooms, Double price, int limit, int offset) throws PersistentException {
		HouseCriteria houseCriteria = new HouseCriteria();
		
		if (title != null && title.trim().length() != 0) {
			houseCriteria.add(Restrictions.ilike("title", "%" + title + "%"));
		}
		
		if (rooms != null) {
			houseCriteria.add(Restrictions.eq("rooms", rooms));
		}
		
		if (price != null) {
			// minPrice <= price <= maxPrice
			houseCriteria.add(Restrictions.le("minPrice", price));
			houseCriteria.add(Restrictions.ge("maxPrice", price));
		}
		return applyPagination(houseCriteria.list(), limit, offset);
	}
	
	private List<House> applyPagination(List<House> houses, int limit, int offset) {
		int count = houses.size();
		
		if (count == 0) {
			limit = 0;
		} else if (offset + limit >= count) {
			limit = count - (offset + 1);
		}
		return houses.subList(offset, offset + limit);
	}
	
	public int getTotalHouses() throws PersistentException {
		return HouseDAO.getTotalNOfHouses();
	}
	
	public House getById(int id) throws ResourceNotFoundException, PersistentException {
		House house = HouseDAO.getHouseByORMID(id);
		if (house == null) {
			throw new ResourceNotFoundException("House not found: id=" + id);
		}
		return house;
	}
	
	public House update(House house, House houseInfo, List<Photo> photos) throws PersistentException {
		if (houseInfo.getAddress() != null) {
			house.setAddress(houseInfo.getAddress());
		}
		
		if (houseInfo.getTitle() != null) {
			house.setTitle(houseInfo.getTitle());
		}
		
		if (houseInfo.getRooms() != 0) {
			house.setRooms(houseInfo.getRooms());
		}
		
		if (houseInfo.getAvailableRooms() != 0) {
			house.setAvailableRooms(houseInfo.getAvailableRooms());
		}
		
		if (houseInfo.getBathRooms() != 0) {
			house.setBathRooms(houseInfo.getBathRooms());
		}
		
		if (houseInfo.getMinPrice() != 0) {
			house.setMinPrice(houseInfo.getMinPrice());
		}
		
		if (houseInfo.getMaxPrice() != 0) {
			house.setMaxPrice(houseInfo.getMaxPrice());
		}
		
		if (houseInfo.getDescription() != null) {
			house.setDescription(houseInfo.getDescription());
		}
		
		for (Photo p : photos) {
			house.photos.add(p);
		}
		
		HouseDAO.save(house);
		HouseDAO.refresh(house);
		return house;
	}
	
	public boolean delete(House house) throws PersistentException {
		house.photos.clear();
		return HouseDAO.deleteAndDissociate(house);
	}
}
