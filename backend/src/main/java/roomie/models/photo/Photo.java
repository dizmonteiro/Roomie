package roomie.models.photo;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;

public class Photo implements Serializable {
	private int ID;
	private String path;
	
	public Photo() {
	}
	
	public int getID() {
		return ID;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	@JsonIgnore
	public int getORMID() {
		return getID();
	}
	
	@JsonIgnore
	public String getPath() {
		return path;
	}
	
	public void setPath(String value) {
		this.path = value;
	}
	
	public String toString() {
		return String.valueOf(getID());
	}
	
}
