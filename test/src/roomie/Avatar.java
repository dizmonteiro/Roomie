/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * <p>
 * This is an automatic generated file. It will be regenerated every time
 * you generate persistence class.
 * <p>
 * Modifying its content may cause the program not work, or your work may lost.
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie;

import java.io.Serializable;

public class Avatar implements Serializable {
	private int ID;
	private String path;
	
	public Avatar() {
	}
	
	public int getID() {
		return ID;
	}
	
	private void setID(int value) {
		this.ID = value;
	}
	
	public int getORMID() {
		return getID();
	}
	
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
