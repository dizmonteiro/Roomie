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
	private final Path root = Paths.get("uploads");
	
	public void init() {
		try {
			Files.createDirectory(root);
		} catch (IOException e) {
			;
		}
	}
	
	public String save(MultipartFile file) {
		try {
			String fileName = new Date().getTime() + "." + FilenameUtils.getExtension(file.getOriginalFilename());
			Files.copy(file.getInputStream(), this.root.resolve(fileName));
			return fileName;
		} catch (Exception e) {
			throw new RuntimeException("Could not store the file. Error: " + e.getMessage());
		}
	}
	
	public boolean delete(String filename) {
		try {
			Files.delete(this.root.resolve(filename));
			return true;
		} catch (IOException e) {
			throw new RuntimeException("Could not delete the file. Error: " + e.getMessage());
		}
	}
	
	public byte[] load(String filename) throws IOException {
		try {
			Path file = root.resolve(filename);
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
