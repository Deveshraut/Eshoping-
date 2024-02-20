package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class OrderDetailsRatingDTO 
{
	private String rating;
	
	public OrderDetailsRatingDTO() {
		// TODO Auto-generated constructor stub
	}

	public OrderDetailsRatingDTO(String rating) {
		super();
		this.rating = rating;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	@Override
	public String toString() {
		return "OrderDetailsRatingDTO [rating=" + rating + "]";
	}
	

}
