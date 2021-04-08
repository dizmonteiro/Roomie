/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */
package roomie;

import java.io.Serializable;
public class House implements Serializable {
	public House() {
	}
	
	private java.util.List this_getList (int key) {
		if (key == ORMConstants.KEY_HOUSE_PHOTOS) {
			return ORM_photos;
		}
		
		return null;
	}
	
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
	};
	
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
	
	private void setId(int value) {
		this.id = value;
	}
	
	public int getId() {
		return id;
	}
	
	public int getORMID() {
		return getId();
	}
	
	public void setAddress(String value) {
		this.address = value;
	}
	
	public String getAddress() {
		return address;
	}
	
	public void setTitle(String value) {
		this.title = value;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setRooms(int value) {
		this.rooms = value;
	}
	
	public int getRooms() {
		return rooms;
	}
	
	public void setAvailableRooms(int value) {
		this.availableRooms = value;
	}
	
	public int getAvailableRooms() {
		return availableRooms;
	}
	
	public void setBathRooms(int value) {
		this.bathRooms = value;
	}
	
	public int getBathRooms() {
		return bathRooms;
	}
	
	public void setMinPrice(double value) {
		this.minPrice = value;
	}
	
	public double getMinPrice() {
		return minPrice;
	}
	
	public void setMaxPrice(double value) {
		this.maxPrice = value;
	}
	
	public double getMaxPrice() {
		return maxPrice;
	}
	
	public void setDescription(String value) {
		this.description = value;
	}
	
	public String getDescription() {
		return description;
	}
	
	public void setFeatures(String value) {
		this.features = value;
	}
	
	public String getFeatures() {
		return features;
	}
	
	private void setORM_Photos(java.util.List value) {
		this.ORM_photos = value;
	}
	
	private java.util.List getORM_Photos() {
		return ORM_photos;
	}
	
	public final roomie.PhotoListCollection photos = new roomie.PhotoListCollection(this, _ormAdapter, ORMConstants.KEY_HOUSE_PHOTOS, ORMConstants.KEY_MUL_ONE_TO_MANY);
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
