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
package roomie.repository.photo;

import org.orm.PersistentException;
import org.orm.PersistentManager;
import roomie.model.photo.Photo;
import roomie.repository.RoomiePersistentManager;

public class PhotoListCollection extends org.orm.util.ORMList {
	public PhotoListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public PhotoListCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	 * Return an iterator over the persistent objects
	 * @return The persistent objects iterator
	 */
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMList
	 * @param value the persistent object
	 */
	public void add(Photo value) {
		if (value != null) {
			super.add(value, null);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMList
	 * @param value the persistent object
	 */
	public void remove(Photo value) {
		super.remove(value, null);
	}
	
	/**
	 * Return true if ORMList contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Photo value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMList
	 * @return The persistent objects array
	 */
	public Photo[] toArray() {
		return (Photo[]) super.toArray(new Photo[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>path</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Photo[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMList
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>ID</li>
	 * <li>path</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Photo[] toArray(String propertyName, boolean ascending) {
		return (Photo[]) super.toArray(new Photo[size()], propertyName, ascending);
	}
	
	/**
	 * Return the persistent object at the specified position in ORMList.
	 * @param index - The specified position
	 * @return - The persistent object
	 */
	public Photo get(int index) {
		return (Photo) super.getImpl(index);
	}
	
	/**
	 * Remove the persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @return Removed persistent object
	 */
	public Photo remove(int index) {
		Photo value = get(index);
		if (value != null) {
			return (Photo) super.removeImpl(index, null);
		}
		return null;
	}
	
	/**
	 * Insert the specified persistent object at the specified position in ORMList.
	 * @param index The specified position
	 * @param value The specified persistent object
	 */
	public void add(int index, Photo value) {
		if (value != null) {
			super.add(index, value, null);
		}
	}
	
	/**
	 * Find the specified position of specified persistent object ORMList.
	 * @param value The persistent object
	 */
	public int indexOf(Photo value) {
		return super.indexOf(value);
	}
	
	/**
	 * Replace the persistent object at the specified position in ORMList with the specified persistent object.
	 * @param index The specified position
	 * @param value The persistent object
	 * @return Return replaced object
	 */
	public Photo set(int index, Photo value) {
		return (Photo) super.set(index, value);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return RoomiePersistentManager.instance();
	}
	
}

