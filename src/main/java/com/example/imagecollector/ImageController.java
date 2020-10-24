package com.example.imagecollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ImageController {

    @Autowired
    ImageService imageService;

    @RequestMapping(value = {"/","/{id}"}, method = RequestMethod.GET, produces = MediaType.IMAGE_JPEG_VALUE)
    public byte[] load_image(@PathVariable(value = "id", required = false) Integer id) throws Exception {
        return imageService.fetchImage(id);
    }


    @RequestMapping(value = "/images", method = RequestMethod.GET)
    public List<Image> getAllImages(){
        return imageService.getAllImages();
    }

}
