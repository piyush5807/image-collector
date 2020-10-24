package com.example.imagecollector;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.data.mongodb.core.query.UpdateDefinition;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ImageRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    public void saveImage(Image image){
        mongoTemplate.insert(image);
    }

    public Image getImageForId(Integer id){

        Query query = new Query();
        query.addCriteria(Criteria.where("image_id").is(id));
        return mongoTemplate.findOne(query, Image.class);
    }

    public List<Image> getAllImages(){

        return mongoTemplate.findAll(Image.class);
    }


    public void updateImage(Image image){
        Query query = new Query();
        query.addCriteria(Criteria.where("image_id").is(image.getImage_id()));

        Integer updated_access_count = image.getNo_of_times_accessed() + 1;

        mongoTemplate.updateFirst(query, Update.update("no_of_times_accessed", updated_access_count), Image.class);
    }
}
