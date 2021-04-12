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
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 * <p>
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie.models.house;

import roomie.models.ORMConstants;
import roomie.models.photo.PhotoListCollection;

import java.io.Serializable;

public class House implements Serializable {
	private int id;
	private String address;
	private String title;
	private int rooms;
	private int availableRooms;
	private int bathRooms;
	private double minPrice;
	private double maxPrice;
	private String description;
	private String features;
	private java.util.List ORM_photos = new java.util.ArrayList();
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	public final PhotoListCollection photos = new PhotoListCollection(this, _ormAdapter, ORMConstants.KEY_HOUSE_PHOTOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public House() {
	}
	
	private java.util.List this_getList(int key) {
		if (key == ORMConstants.KEY_HOUSE_PHOTOS) {
			return ORM_photos;
		}
		
		return null;
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public int getRooms() {
		return rooms;
	}
	
	public void setRooms(int value) {
		this.rooms = value;
	}
	
	public int getAvailableRooms() {
		return availableRooms;
	}
	
	public void setAvailableRooms(int value) {
		this.availableRooms = value;
	}
	
	public int getBathRooms() {
		return bathRooms;
	}
	
	public void setBathRooms(int value) {
		this.bathRooms = value;
	}
	
	public double getMinPrice() {
		return minPrice;
	}
	
	public void setMinPrice(double value) {
		this.minPrice = value;
	}
	
	public double getMaxPrice() {
		return maxPrice;
	}
	
	public void setMaxPrice(double value) {
		this.maxPrice = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getFeatures() {
		return features;
	}
	
	public void setFeatures(String value) {
		this.features = value;
	}
	
	private java.util.List getORM_Photos() {
		return ORM_photos;
	}
	
	private void setORM_Photos(java.util.List value) {
		this.ORM_photos = value;
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
