package com.zt.dao;

import com.zt.model.Boot;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by fenxio on 2016/10/17.
 */
public interface BootDao extends MongoRepository<Boot, String> {

}
