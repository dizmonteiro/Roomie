package roomie.services;

import org.orm.PersistentException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import roomie.helpers.FileUtils;
import roomie.models.photo.Photo;
import roomie.models.photo.PhotoDAO;

import java.io.IOException;


/**
 * @author: João Abreu
 * @created: 17/04/2021 - 16:05
 */

@Service
public class PhotoService {
    @Autowired
    public FileUtils fileUtils;

    public Photo store(MultipartFile file) throws PersistentException {
        String path;
        if (file == null) {
            path = fileUtils.save("house-default.png");
        } else {
            path = fileUtils.save(file);
        }
        Photo photo = PhotoDAO.createPhoto();
        photo.setPath(path);
        PhotoDAO.save(photo);
        return photo;
    }

    public byte[] load(Photo photo) throws IOException {
        return fileUtils.load(photo.getPath());
    }

    public boolean delete(Photo photo) throws PersistentException {
        return fileUtils.delete(photo.getPath());
    }

    public boolean update(Photo photo, MultipartFile file) throws PersistentException {
        if (file != null) {
            String path = fileUtils.save(file);
            delete(photo);
            photo.setPath(path);
        }
        PhotoDAO.save(photo);
        PhotoDAO.refresh(photo);
        return true;
    }
}
