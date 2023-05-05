package com.emarket.webservice.docker.service;

import java.util.List;

import com.emarket.webservice.docker.model.Item;

public interface Services {

	public List<Item> getAllItems();
	public Item getItemById(int id);
	public void save(Item item);
	public void delete(int id);
}
