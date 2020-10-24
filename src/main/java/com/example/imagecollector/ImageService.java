package com.example.imagecollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import sun.misc.BASE64Encoder;

import javax.net.ssl.HttpsURLConnection;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.SecureRandom;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    ImageRepository repository;

    @Value("${website.url}")
    private String base_url;

    public byte[] fetchImage(Integer id) throws Exception{
        if(id == null){
            return downloadImage(id);
        }

        Image image = repository.getImageForId(id);

        if(image == null){
            image = new Image();
            image.setNo_of_times_accessed(1);
            image.setImage_id(id);
            image.setUrl(getImageUrl(id));

            repository.saveImage(image);
        }else{
            repository.updateImage(image);
        }

        return downloadImage(id);

    }

    public byte[] downloadImage(Integer id) throws Exception{

        String url_str = getImageUrl(id);

        System.out.println("url str is " + url_str);

        URL url = new URL(url_str);

        InputStream in = new BufferedInputStream(url.openStream());
        ByteArrayOutputStream out = new ByteArrayOutputStream();

        byte[] buf = new byte[1024];
        int n = 0;

        while (-1!=(n=in.read(buf))) {
            out.write(buf, 0, n);
        }
        out.close();
        in.close();
        byte[] response = out.toByteArray();

        return response;

    }

    public List<Image> getAllImages(){

        return repository.getAllImages();
    }

    private String getImageUrl(Integer id){
        return id == null ? base_url + "/1280/720" : base_url + "/id/" + id + "/1280/720";
    }

}
