package roomie.services;

/**
 * @author: João Abreu
 * @created: 17/04/2021 - 15:24
 */

import org.hibernate.criterion.Restrictions;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.springframework.stereotype.Service;
import roomie.exception.ResourceNotFoundException;
import roomie.models.RoomiePersistentManager;
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
		if (offset + limit >= count) {
			limit = count - (offset + 1);
		}
		return houses.subList(offset, offset + limit);
	}
	
	public House getById(int id) throws ResourceNotFoundException, PersistentException {
		House house = HouseDAO.getHouseByORMID(id);
		if (house == null) {
			throw new ResourceNotFoundException("House not found: id=" + id);
		}
		return house;
	}
	
	public boolean delete(House house) throws PersistentException {
		house.photos.clear();
		
		try {
			PersistentSession session = RoomiePersistentManager.instance().getSession();
			session.clear();
		} catch (Exception e) {
			e.printStackTrace();
			throw new PersistentException(e);
		}
		
		return HouseDAO.delete(house);
	}
	
}
