package com.gearservice.controller;

import com.gearservice.model.cheque.Photo;
import com.gearservice.service.PhotoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
public class PhotoController {

    @Autowired PhotoService photoService;

    @ResponseStatus(value = HttpStatus.OK)
    @RequestMapping(value = "/api/upload-image", method = RequestMethod.POST)
    public void uploadImage(@RequestParam("file") MultipartFile photo,
                            @RequestParam("chequeID") Long chequeID,
                            @RequestParam("username") String username) {
        photoService.uploadImage(photo, chequeID, username);
    }

    @RequestMapping(value = "/api/photo/{photoID}", method = RequestMethod.GET)
    public Photo getPhotoByID(@PathVariable String photoID) {return photoService.getPhotoByID(photoID);}

    @RequestMapping(value = "/api/photo/{photoID}", method = RequestMethod.DELETE)
    @ResponseStatus(value = HttpStatus.OK)
    public void deletePhotoByID(@PathVariable String photoID) {photoService.deletePhotoByID(photoID);}

    @RequestMapping(value = "/api/photo/cheque/{chequeID}", method = RequestMethod.GET)
    public List<Photo> getListOfPhotoExcludeBytesFromCheque(@PathVariable String chequeID) {
        return photoService.getListOfPhotoExcludeBytesFromCheque(chequeID);
    }


}
