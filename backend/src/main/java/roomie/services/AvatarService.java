package roomie.services;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import roomie.helpers.FileUtils;
import roomie.models.avatar.Avatar;
import roomie.models.avatar.AvatarDAO;

import java.io.IOException;


/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 11:35
 */

@Service
public class AvatarService {
	@Autowired
	public FileUtils fileUtils;
	
	public Avatar store(MultipartFile file) throws PersistentException {
		String path;
		if (file == null) {
			path = fileUtils.save("user-default.png");
		} else {
			path = fileUtils.save(file);
		}
		Avatar avatar = AvatarDAO.createAvatar();
		avatar.setPath(path);
		AvatarDAO.save(avatar);
		return avatar;
	}
	
	public byte[] load(Avatar avatar) throws IOException {
		return fileUtils.load(avatar.getPath());
	}
	
	public boolean delete(Avatar avatar) throws PersistentException {
		return fileUtils.delete(avatar.getPath());
	}
}
