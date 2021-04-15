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
import roomie.models.auth.UpdatePasswordRequest;
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
	
	public void exists(Landlord landlord) throws PersistentException {
		if (userUtils.existsByEmail(landlord.getEmail())) {
			throw new ErrorDetails("There is already a user with that email");
		}
	}
	
	public Landlord register(Landlord landlord, Avatar avatar) throws PersistentException {
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
	
	public boolean delete(Landlord landlord) throws PersistentException, ResourceNotFoundException {
		LandlordDAO.evict(landlord);
		return LandlordDAO.delete(landlord);
	}
	
	public Landlord update(Landlord landlord, Landlord landlordInfo) throws PersistentException {
		if (landlordInfo.getName() != null) {
			landlord.setName(landlordInfo.getName());
		}
		
		if (landlordInfo.getUsername() != null) {
			landlord.setUsername(landlordInfo.getUsername());
		}
		
		if (landlordInfo.getPhone() != null) {
			landlord.setPhone(landlordInfo.getPhone());
		}
		
		if (landlordInfo.getSex() != null) {
			landlord.setSex(landlordInfo.getSex());
		}
		
		if (landlordInfo.getAddress() != null) {
			landlord.setAddress(landlordInfo.getAddress());
		}
		
		LandlordDAO.save(landlord);
		LandlordDAO.refresh(landlord);
		return landlord;
	}
	
	public boolean updatePassword(Landlord landlord, UpdatePasswordRequest body) throws PersistentException {
		if (!passwordEncoder.matches(body.getOldPassword(), landlord.getPassword())) {
			throw new ErrorDetails("Current password is not correct");
		}
		
		if (body.getOldPassword().equals(body.getNewPassword())) {
			throw new ErrorDetails("Current and new passwords can't be the same");
		}
		
		landlord.setPassword(passwordEncoder.encode(body.getNewPassword()));
		
		LandlordDAO.save(landlord);
		LandlordDAO.refresh(landlord);
		return true;
	}
	
}
