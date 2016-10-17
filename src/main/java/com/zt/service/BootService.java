package com.zt.service;

import com.zt.dao.BootDao;
import com.zt.model.Boot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by fenxio on 2016/10/17.
 */
@Service
public class BootService {

    @Autowired
    private MongoTemplate mongoTemplate;

    public void save(Boot boot) {
        mongoTemplate.save(boot);
    }

    public Boot findById(Integer id) {
        return mongoTemplate.findById(id, Boot.class);
    }

    public List<Boot> findAll() {
        return mongoTemplate.findAll(Boot.class);
    }

    public Integer updateBoot(Integer id, Boot boot) {
        Query query = new Query(Criteria.where("id").is(id));
        Update update = new Update();
        update.set("name", boot.getName());
        mongoTemplate.updateFirst(query, update, Boot.class);
        return 0;
    }

    public Boot deleteById(Integer id) {
        Query query = new Query(Criteria.where("id").is(id));
        return mongoTemplate.findAndRemove(query, Boot.class);
    }
}
