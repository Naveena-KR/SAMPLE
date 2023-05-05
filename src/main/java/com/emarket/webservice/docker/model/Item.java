package com.emarket.webservice.docker.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;
import org.springframework.lang.NonNullApi;

import com.mongodb.lang.NonNull;

import lombok.Data;


//@CompoundIndex(def = "{'name': 1, 'quality': 1}", unique = true)
@Document(collection="duplicate2")
@Data
public class Item {

	@Id
	private Object id;
	
	//	@Indexed
	//	@DBRef(lazy = true) for all relations this is embedded document reference 
	//	Unique(true);
	/*	@Field("email")    this acts as a key in json
		private EmailAddress emailAddress;			*/
	// @NonNull
	// @Indexed(unique = true)
	/* @Field
	   private String field = "CustomDefaultValue"; */
	private String name;
	@NonNull
	private String quality;
	private long rate;
	
}
