package com.emarket.webservice.docker.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;

import com.emarket.webservice.docker.model.Item;
import com.emarket.webservice.docker.repository.MarketRepository;



@Service
public class MarketService implements Services{
	@Autowired
	private MarketRepository marketRepository;

	@Override
	public List<Item> getAllItems() {
		// TODO Auto-generated method stub
		List<Item> items= (List<Item>) marketRepository.findAll();
		return items;
	}

	@Override
	public Item getItemById(int id) {
		// TODO Auto-generated method stub
		return marketRepository.findById(id).get();
	}

	@Override
	public void save(Item item) {
		// TODO Auto-generated method stub
		marketRepository.save(item);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		marketRepository.deleteById(id);	
	}
}
