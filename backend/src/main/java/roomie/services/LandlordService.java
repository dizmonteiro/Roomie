package roomie.services;

/**
 * @author: Vasco Ramos
 * @created: 13/04/2021 - 11:02
 */

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import roomie.exception.ErrorDetails;
import roomie.exception.ResourceNotFoundException;
import roomie.helpers.UserUtils;
import roomie.models.avatar.Avatar;
import roomie.models.avatar.AvatarDAO;
import roomie.models.landlord.Landlord;
import roomie.models.landlord.LandlordDAO;

@Service
public class LandlordService {
	@Autowired
	private UserUtils userUtils;
	
	private BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
	
	public Landlord register(Landlord landlord, Avatar avatar) throws PersistentException {
		if (userUtils.existsByEmail(landlord.getEmail())) {
			throw new ErrorDetails("There is already a user with that email");
		}
		
		if (avatar == null) {
			avatar = AvatarDAO.createAvatar();
			AvatarDAO.save(avatar);
		}
		
		landlord.setPassword(passwordEncoder.encode(landlord.getPassword()));
		landlord.setAvatar(avatar);
		
		LandlordDAO.save(landlord);
		return landlord;
	}
	
	public Landlord getById(int id) throws ResourceNotFoundException, PersistentException {
		Landlord landlord = LandlordDAO.getLandlordByORMID(id);
		if (landlord == null) {
			throw new ResourceNotFoundException("Landlord not found: id=" + id);
		}
		return landlord;
	}
	
}
