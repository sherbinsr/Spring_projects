package com.stroreimg.img;

import com.fasterxml.jackson.databind.util.JSONPObject;
import com.stroreimg.img.entity.ImageData;
import com.stroreimg.img.repository.StorageRepository;
import com.stroreimg.img.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Base64;
import java.util.Optional;



@SpringBootApplication
@RestController
@RequestMapping("/image")
public class ImgApplication {


	@Autowired
	private StorageService service;

	@Autowired
	private  StorageRepository storageRepository;
	@PostMapping
	public ResponseEntity<?> uploadImage(@RequestParam("image")MultipartFile file) throws IOException {
		String uploadImage = service.uploadImage(file);
		return ResponseEntity.status(HttpStatus.OK).body(uploadImage);
	}

	@GetMapping("/{fileName}")
	public ResponseEntity<?> downloadImage(@PathVariable String fileName)
	{
	byte[] imageData =service.downloadImage(fileName);
	return  ResponseEntity.status(HttpStatus.OK)
			.contentType(MediaType.valueOf("image/png"))
			.body(imageData);
	}
	/*
	@GetMapping("/image/{id}")
	public ResponseEntity<?> getImageJson(@PathVariable Long id) {
		Optional<ImageData> optionalImage =storageRepository.findById(id);
		if (optionalImage.isPresent()) {
			ImageData image = optionalImage.get();

			// Convert the image data to a Base64-encoded string
			String base64Image = Base64.getEncoder().encodeToString(image.getImageData());

			// Create a JSON object
			JSONObject jsonObject = new JSONObject;
			jsonObject.addProperty("id", image.getId());
			jsonObject.addProperty("name", image.getName());
			jsonObject.addProperty("imageData", base64Image);

			return ResponseEntity.ok(jsonObject.toString());
		} else {
			return ResponseEntity.notFound().build();
		}
	}

	 */
	public static void main(String[] args) {
		SpringApplication.run(ImgApplication.class, args);
	}

}
