package com.rarcos.real_estate.controllers;

import java.io.IOException;
import java.util.Date;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.rarcos.real_estate.models.House;
import com.rarcos.real_estate.services.HouseService;
import com.rarcos.real_estate.utils.FileUploadUtil;

@Controller
public class HouseController {

	@Autowired
	public HouseService servicio;

	@GetMapping({ "/", "/house/list" })
	public String listado(Model model) {
		if (servicio.getAllHouses() != null)
			model.addAttribute("listHouses", servicio.getAllHouses());
		return "list";
	}

	@GetMapping("/house/new")
	public String newHouseForm(Model model) {
		model.addAttribute("houseForm", new House());
		return "form";
	}

	@PostMapping("/house/new/submit")
	public String newHouseSubmit(@Valid @ModelAttribute("houseForm") House nuevoHouse, BindingResult bindingResult,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {
		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if(!fileName.isEmpty())
			nuevoHouse.setPhotos(fileName);
		nuevoHouse.setCreationDateTime(new Date(System.currentTimeMillis()));
		if (bindingResult.hasErrors()) {
			return "form";
		} else {
			House newHouse = servicio.addHouse(nuevoHouse);
			String uploadDir = "user-photos/" + newHouse.getId();
			if (!fileName.isEmpty())
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			return "redirect:/house/list";
		}

	}

	@GetMapping("/house/edit/{id}")
	public String editHouseForm(@PathVariable long id, Model model) {

		Optional<House> house = servicio.getHouseById(id);

		if (house.isPresent()) {
			model.addAttribute("houseForm", house.get());
			return "form";
		} else {
			return "redirect:/house/new";
		}

	}

	@PostMapping("/house/edit/submit")
	public String editHouseSubmit(@Valid @ModelAttribute("houseForm") House house, BindingResult bindingResult,
			@RequestParam("image") MultipartFile multipartFile) throws IOException {

		String fileName = StringUtils.cleanPath(multipartFile.getOriginalFilename());
		if(!fileName.isEmpty())
			house.setPhotos(fileName);

		if (bindingResult.hasErrors()) {
			return "form";
		} else {
			servicio.updateHouse(house, fileName);
			String uploadDir = "user-photos/" + house.getId();
			if (!fileName.isEmpty())
				FileUploadUtil.saveFile(uploadDir, fileName, multipartFile);
			return "redirect:/house/list";
		}
	}

}
