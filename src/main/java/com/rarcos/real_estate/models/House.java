package com.rarcos.real_estate.models;

import java.util.Date;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotEmpty;

import org.springframework.data.annotation.Transient;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "houses")
@EntityListeners(AuditingEntityListener.class)
public class House {
	
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	private long id;
	@Column(nullable = false)
	@NotEmpty
	private String property;
	@Column(nullable = false)
	@NotEmpty
	private String shortDescription;
	private String address;
	private double price;
	@Temporal(TemporalType.TIMESTAMP)
	private Date creationDateTime;
	@NotEmpty
	private String phone;
	private String position;
	private String coordinates;
	private String longDescription;
	private int rooms;
	private double meters;
	@Column(columnDefinition = "boolean default false")
	private boolean parking;
	private String photos;

	
	public House() {
	}

	public House(String property, String shortDescription, String address, double price, Date creationDateTime,
			String phone, String position, String coordinates, String longDescription, int rooms, double meters,
			boolean parking) {
		
		this.property = property;
		this.shortDescription = shortDescription;
		this.address = address;
		this.price = price;
		this.creationDateTime = creationDateTime;
		this.phone = phone;
		this.position = position;
		this.coordinates = coordinates;
		this.longDescription = longDescription;
		this.rooms = rooms;
		this.meters = meters;
		this.parking = parking;		
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getProperty() {
		return property;
	}

	public void setProperty(String property) {
		this.property = property;
	}

	public String getShortDescription() {
		return shortDescription;
	}

	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getCreationDateTime() {
		return creationDateTime;
	}

	public void setCreationDateTime(Date creationDateTime) {
		this.creationDateTime = creationDateTime;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(String coordinates) {
		this.coordinates = coordinates;
	}

	public String getLongDescription() {
		return longDescription;
	}

	public void setLongDescription(String longDescription) {
		this.longDescription = longDescription;
	}

	public int getRooms() {
		return rooms;
	}

	public void setRooms(int rooms) {
		this.rooms = rooms;
	}

	public double getMeters() {
		return meters;
	}

	public void setMeters(double meters) {
		this.meters = meters;
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}
	
	@Transient
	public String getPhotos() {
//		if (photos == null || this.id == 0) return null;
//        
//        return "/user-photos/" + id + "/" + photos;
		return photos;
	}

	public void setPhotos(String photos) {
		this.photos = photos;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, coordinates, creationDateTime, id, longDescription, meters, parking, phone,
				position, price, property, rooms, shortDescription);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		House other = (House) obj;
		return Objects.equals(address, other.address) && Objects.equals(coordinates, other.coordinates)
				&& Objects.equals(creationDateTime, other.creationDateTime) && id == other.id
				&& Objects.equals(longDescription, other.longDescription)
				&& Double.doubleToLongBits(meters) == Double.doubleToLongBits(other.meters) && parking == other.parking
				&& Objects.equals(phone, other.phone) && Objects.equals(position, other.position)
				&& Double.doubleToLongBits(price) == Double.doubleToLongBits(other.price)
				&& Objects.equals(property, other.property) && rooms == other.rooms
				&& Objects.equals(shortDescription, other.shortDescription);
	}

	@Override
	public String toString() {
		return "House [id=" + id + ", property=" + property + ", shortDescription=" + shortDescription + ", address="
				+ address + ", price=" + price + ", creationDateTime=" + creationDateTime + ", phone=" + phone
				+ ", position=" + position + ", coordinates=" + coordinates + ", longDescription=" + longDescription
				+ ", rooms=" + rooms + ", meters=" + meters + ", parking=" + parking + "]";
	}
	
	
}
