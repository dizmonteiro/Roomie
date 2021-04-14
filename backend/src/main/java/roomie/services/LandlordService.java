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
	
	public Landlord register(Landlord landlord) throws PersistentException {
		if (userUtils.existsByEmail(landlord.getEmail())) {
			throw new ErrorDetails("There is already a user with that email");
		}
		
		Avatar avatar = AvatarDAO.createAvatar();
		AvatarDAO.save(avatar);
		
		landlord.setPassword(passwordEncoder.encode(landlord.getPassword()));
		landlord.setAvatar(avatar);
		
		LandlordDAO.save(landlord);
		return landlord;
	}
	
}
