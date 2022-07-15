package com.rarcos.real_estate.services;

import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rarcos.real_estate.models.House;
import com.rarcos.real_estate.repositories.HouseRepository;

@Service
public class HouseService {

	@Autowired
	private HouseRepository repository;

	public House addHouse(House e) {
		return repository.save(e);
	}

	public List<House> getAllHouses() {
		return repository.findAll();
	}

	public Optional<House> getHouseById(long id) {
		return repository.findById(id);
	}

	public Optional<House> updateHouse(House house, String fileName) {
		Optional<House> editHouse = repository.findById(house.getId());
		editHouse.ifPresent(t -> t.setProperty(house.getProperty()));
		editHouse.ifPresent(t -> t.setShortDescription(house.getShortDescription()));
		editHouse.ifPresent(t -> t.setAddress(house.getAddress()));
		editHouse.ifPresent(t -> t.setPrice(house.getPrice()));
		editHouse.ifPresent(t -> t.setCreationDateTime(house.getCreationDateTime()));
		editHouse.ifPresent(t -> t.setPhone(house.getPhone()));
		editHouse.ifPresent(t -> t.setPosition(house.getPosition()));
		editHouse.ifPresent(t -> t.setCoordinates(house.getCoordinates()));
		editHouse.ifPresent(t -> t.setLongDescription(house.getLongDescription()));
		editHouse.ifPresent(t -> t.setRooms(house.getRooms()));
		editHouse.ifPresent(t -> t.setMeters(house.getMeters()));
		editHouse.ifPresent(t -> t.setParking(house.isParking()));
		if (!fileName.isEmpty())
			editHouse.ifPresent(t -> t.setPhotos(fileName));
		editHouse.ifPresent(t -> repository.save(editHouse.get()));
	    return editHouse;
	}

	@PostConstruct
	public void init() {
//		repository.save(new House("InmoAxarquía", "Piso en Teatinos para estudiantes", "C/ Mesonero Romanos, 2", 200000, new Date(System.currentTimeMillis()), "+34 123456789", "position", "coordinates", "long description", 4, 200, true));
//		repository.save(new House("InmoAxarquía", "Piso en Teatinos para estudiantes", "C/ Mesonero Romanos, 2", 200000, new Date(System.currentTimeMillis()), "+34 123456789", "position", "coordinates", "long description", 4, 200, true));
	}

}
