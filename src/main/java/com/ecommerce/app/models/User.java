package com.ecommerce.app.models;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.UniqueElements;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ecommerce.app.dto.request.ProductDetailsRequest;
import com.ecommerce.app.dto.request.ShoppingCartProductsRequest;

import lombok.Data;

 
@Data   //@Data annotation use to generates getters and setters for all fields.
@Document(collection = "users")  //@Document annotation use to set the collection name that will be used by the model. If the collection doesn’t exist, MongoDB will create it.

public class User {
	
	@Id  // Specify the MongoDB document’s primary key _id using the @Id annotation
	private String id;
	 
	@Field(value = "first_name")
	@NotBlank //Validates that the property is not null or whitespace. But, it can be applied only to text values.	 
	@Size(max = 20) //Indicates that the property should have a minimum of two characters and maximum is given by max attribute. 
	private String firstname;
	 
	@Field(value = "last_name")
	@NotBlank //Validates that the property is not null or whitespace. But, it can be applied only to text values.
	@Size(max = 20) //Indicates that the property should have a minimum of two characters and maximum is given by max attribute. 
	private String lastname;

	 
	@NotBlank  //Validates that the property is not null or whitespace. But, it can be applied only to text values.
	@Size(max = 50) //Indicates that the property should have a minimum of two characters and maximum is given by max attribute. 
	@Email
	private String email;

	 
	@NotBlank //Validates that the property is not null or whitespace. But, it can be applied only to text values.  
	@Size(max = 120) //Indicates that the property should have a minimum of two characters and maximum is given by max attribute. 
	private String password;

	@DBRef   //provides relationships mapping of MongoDB domain model objects
	private Set<Role> roles = new HashSet<>();
	
	@Field(value = "wish_list")
	private List<ProductDetailsRequest> wishList = new ArrayList<>();
	
	@Field(value = "shopping_cart")
	private List<ShoppingCartProductsRequest> shoppingCart = new ArrayList<>();
	
	private Map<String,Address> addresses = new HashMap<>();
	
	@Field(value = "default_address")
	private Address defaultAddress;
	
	public User() {
	}

	public User(String firstname, String lastname, String email, String password) {
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
	}
}
