package com.example.ratingservice.services;

import com.example.ratingservice.entities.Rating;
import com.example.ratingservice.repositories.RatingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RatingService {

    @Autowired
    private RatingRepository ratingRepository;

    // create
    public Rating create(Rating rating) {
        return ratingRepository.insert(rating);
    }

    //get all ratings
    public List<Rating> getRatings() {
        return ratingRepository.findAll();
    }


    //get all by userId
    public List<Rating> getRatingById(String id) {
        return ratingRepository.findByUserId(id);
    }

    //get all by hotel
    public List<Rating> getRatingByHotelId(String hotelId) {
        return ratingRepository.findByHotelId(hotelId);
    }
}
