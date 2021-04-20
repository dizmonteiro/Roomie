package roomie.models.house;

/**
 * Licensee: vr(Universidade do Minho)
 * License Type: Academic
 */

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import roomie.models.ORMConstants;
import roomie.models.landlord.Landlord;
import roomie.models.photo.Photo;
import roomie.models.photo.PhotoListCollection;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class House implements Serializable {
	@Schema(hidden = true)
	private int id;
	private Landlord landlord;
	@NotNull
	private String address;
	@NotNull
	private String title;
	@NotNull
	private int rooms;
	@NotNull
	private int availableRooms;
	@NotNull
	private int bathRooms;
	@NotNull
	private double minPrice;
	@NotNull
	private double maxPrice;
	@NotNull
	private String description;
	@NotNull
	private String features;
	private List<Photo> ORM_photos = new ArrayList<>();
	org.orm.util.ORMAdapter _ormAdapter = new org.orm.util.AbstractORMAdapter() {
		public java.util.List getList(int key) {
			return this_getList(key);
		}
		
		public void setOwner(Object owner, int key) {
			this_setOwner(owner, key);
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
	
	private void this_setOwner(Object owner, int key) {
		if (key == ORMConstants.KEY_HOUSE_LANDLORD) {
			this.landlord = (Landlord) owner;
		}
	}
	
	public int getId() {
		return id;
	}
	
	private void setId(int value) {
		this.id = value;
	}
	
	@JsonIgnore
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
	
	public Landlord getLandlord() {
		return landlord;
	}
	
	public void setLandlord(Landlord value) {
		if (landlord != null) {
			landlord.houses.remove(this);
		}
		if (value != null) {
			value.houses.add(this);
		}
	}
	
	private Landlord getORM_Landlord() {
		return landlord;
	}
	
	/**
	 * This method is for internal use only.
	 */
	public void setORM_Landlord(Landlord value) {
		this.landlord = value;
	}
	
	private java.util.List getORM_Photos() {
		return ORM_photos;
	}
	
	private void setORM_Photos(java.util.List value) {
		this.ORM_photos = value;
	}
	
	public List<Integer> getPhotos() {
		return ORM_photos.stream().map(Photo::getID).collect(Collectors.toList());
	}
	
	public String toString() {
		return String.valueOf(getId());
	}
	
}
