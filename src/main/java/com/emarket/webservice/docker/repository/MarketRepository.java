package com.emarket.webservice.docker.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.emarket.webservice.docker.model.Item;


@Repository
public interface MarketRepository extends CrudRepository<Item,Integer>{//Or MongoRepository

}
