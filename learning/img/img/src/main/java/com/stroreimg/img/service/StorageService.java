package com.stroreimg.img.service;

import com.stroreimg.img.entity.ImageData;
import com.stroreimg.img.repository.StorageRepository;
import com.stroreimg.img.util.ImageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Optional;

@Service
public class StorageService {

    @Autowired
    private StorageRepository repository;

    public String uploadImage(MultipartFile File) throws IOException {
        ImageData imageData = repository.save(ImageData.builder()
                .name(File.getOriginalFilename())
                .type(File.getContentType())
                .imageData(ImageUtils.compressImage(File.getBytes())).build());

        if(imageData!=null)
        {
            return "file uploaded successfully:"+File.getOriginalFilename();
        }
        return null;
    }
    public byte[]downloadImage(String fileName)
    {
        Optional<ImageData> dbImageData = repository.findByName(fileName);
       byte[] images = ImageUtils.decompressImage(dbImageData.get().getImageData());
       return images;
    }
}
