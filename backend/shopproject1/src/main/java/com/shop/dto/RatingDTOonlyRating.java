package com.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class RatingDTOonlyRating {
    private String rating;

    public RatingDTOonlyRating() {
    }

    public RatingDTOonlyRating(String rating) {
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
        return "RatingDTOonlyRating{" +
                "rating='" + rating + '\'' +
                '}';
    }
}
