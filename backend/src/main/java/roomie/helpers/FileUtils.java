package roomie.helpers;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;

/**
 * @author: Vasco Ramos
 * @created: 14/04/2021 - 11:36
 */

@Component
public class FileUtils {
	private final Path uploads = Paths.get("uploads");
	private final Path defaults = Paths.get("images");
	
	
	public void init() {
		try {
			Files.createDirectory(uploads);
		} catch (IOException e) {
			;
		}
	}
	
	public String save(String filename) {
		try {
			String newFilename = new Date().getTime() + "." + FilenameUtils.getExtension(filename);
			Files.copy(this.defaults.resolve(filename), this.uploads.resolve(newFilename));
			return newFilename;
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}
	
	public String save(MultipartFile file) {
		try {
			String fileName = new Date().getTime() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
			Files.copy(file.getInputStream(), this.uploads.resolve(fileName));
			return fileName;
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}
	
	public boolean delete(String filename) {
		try {
			Files.delete(this.uploads.resolve(filename));
			return true;
		} catch (IOException e) {
			throw new RuntimeException("Could not delete the file. Error: " + e.getMessage());
		}
	}
	
	public byte[] load(String filename) throws IOException {
		try {
			Path file = uploads.resolve(filename);
			Resource resource = new UrlResource(file.toUri());
			
			if (resource.exists() || resource.isReadable()) {
				return IOUtils.toByteArray(resource.getInputStream());
			} else {
				throw new RuntimeException("Could not read the file!");
			}
		} catch (MalformedURLException e) {
			throw new RuntimeException("Error: " + e.getMessage());
		}
	}
}
