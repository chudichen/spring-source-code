package com.chu.beans;

import com.chu.lang.Nullable;

import java.io.Serializable;
import java.util.*;

/**
 * @author chudichen
 * @date 2021-04-15
 */
public class MutablePropertyValues implements PropertyValues, Serializable {

	private static final long serialVersionUID = 683448281753822343L;

	private final List<PropertyValue> propertyValueList;

	@Nullable
	private Set<String> processedProperties;

	private volatile boolean converted = false;

	public MutablePropertyValues() {
		propertyValueList = new ArrayList<>(0);
	}

	public MutablePropertyValues(@Nullable PropertyValues original) {
		if (original != null) {
			PropertyValue[] pvs = original.getPropertyValues();
			this.propertyValueList = new ArrayList<>(pvs.length);
			for (PropertyValue pv : pvs) {
				this.propertyValueList.add(new PropertyValue(pv));
			}
		} else {
			this.propertyValueList = new ArrayList<>(0);
		}
	}

	public MutablePropertyValues(@Nullable Map<?, ?> original) {
		if (original != null) {
			this.propertyValueList = new ArrayList<>(original.size());
			original.forEach((attrName, attrValue) ->
					this.propertyValueList.add(new PropertyValue(attrName.toString(), attrValue)));
		} else {
			this.propertyValueList = new ArrayList<>(0);
		}
	}

	public MutablePropertyValues(@Nullable List<PropertyValue> propertyValueList) {
		this.propertyValueList = (propertyValueList != null ? propertyValueList : new ArrayList<>());
	}

	public MutablePropertyValues addPropertyValues(@Nullable Map<?, ?> other) {
		if (other != null) {
			other.forEach((attrName, attrValue) -> addPropertyValue(new PropertyValue(attrName.toString(), attrValue)));
		}
		return this;
	}

	public MutablePropertyValues addPropertyValue(PropertyValue pv) {
		for (int i = 0; i < this.propertyValueList.size(); i++) {
			PropertyValue currentPv = this.propertyValueList.get(i);
			if (currentPv.getName().equals(pv.getName())) {
				pv = mergeIfRequired(pv, currentPv);
				setPropertyValueAt(pv, i);
				return this;
			}
		}
		this.propertyValueList.add(pv);
		return this;
	}

	public void addPropertyValue(String propertyName, Object propertyValue) {
		addPropertyValue(new PropertyValue(propertyName, propertyValue));
	}

	public MutablePropertyValues add(String propertyName, @Nullable Object propertyValue) {
		addPropertyValue(new PropertyValue(propertyName, propertyValue));
		return this;
	}

	public void setPropertyValueAt(PropertyValue pv, int i) {
		this.propertyValueList.add(i, pv);
	}

	private PropertyValue mergeIfRequired(PropertyValue newPv, PropertyValue currentPv) {
		Object value = newPv.getValue();
		if (value instanceof Mergeable) {
			Mergeable mergeable = (Mergeable) value;
			if (mergeable.isMergeEnabled()) {
				Object merged = mergeable.merge(currentPv.getValue());
				return new PropertyValue(newPv.getName(), merged);
			}
		}
		return newPv;
	}

	public void removePropertyValue(PropertyValue pv) {
		this.propertyValueList.remove(pv);
	}

	public void removePropertyValue(String propertyName) {
		this.propertyValueList.remove(getPropertyValue(propertyName));
	}

	@Override
	public Iterator<PropertyValue> iterator() {
		return Collections.unmodifiableList(this.propertyValueList).iterator();
	}

	@Override
	public Spliterator<PropertyValue> spliterator() {
		return Spliterators.spliterator(this.propertyValueList, 0);
	}

	@Override
	public PropertyValue[] getPropertyValues() {
		return this.propertyValueList.toArray(new PropertyValue[0]);
	}

	@Override
	@Nullable
	public PropertyValue getPropertyValue(String propertyName) {
		for (PropertyValue pv : this.propertyValueList) {
			if (pv.getName().equals(propertyName)) {
				return pv;
			}
		}
		return null;
	}

	@Nullable
	public Object get(String propertyName) {
		PropertyValue pv = getPropertyValue(propertyName);
		return pv != null ? pv.getValue() : null;
	}

	@Override
	public PropertyValues changesSince(PropertyValues old) {
		MutablePropertyValues changes = new MutablePropertyValues();
		if (old == this) {
			return changes;
		}

		for (PropertyValue newPv : this.propertyValueList) {
			PropertyValue pvOld = old.getPropertyValue(newPv.getName());
			if (pvOld == null || !pvOld.equals(newPv)) {
				changes.addPropertyValue(newPv);
			}
		}
		return changes;
	}

	@Override
	public boolean contains(String propertyName) {
		return (getPropertyValue(propertyName) != null ||
				(this.processedProperties != null && this.processedProperties.contains(propertyName)));
	}

	@Override
	public boolean isEmpty() {
		return this.propertyValueList.isEmpty();
	}

	public void registerProcessedProperty(String propertyName) {
		if (this.processedProperties == null) {
			this.processedProperties = new HashSet<>(4);
		}
		this.processedProperties.add(propertyName);
	}

	public void clearProcessedProperty(String propertyName) {
		if (this.processedProperties != null) {
			this.processedProperties.remove(propertyName);
		}
	}

	public void setConverted() {
		this.converted = true;
	}

	public boolean isConverted() {
		return this.converted;
	}

	@Override
	public boolean equals(@Nullable Object other) {
		return (this == other || (other instanceof MutablePropertyValues &&
				this.propertyValueList.equals(((MutablePropertyValues) other).propertyValueList)));
	}

	@Override
	public int hashCode() {
		return this.propertyValueList.hashCode();
	}
}
