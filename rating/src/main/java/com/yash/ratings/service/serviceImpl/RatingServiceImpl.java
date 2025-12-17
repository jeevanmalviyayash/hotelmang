package com.yash.ratings.service.serviceImpl;

import com.yash.ratings.entities.Rating;
import com.yash.ratings.exception.ResourceNotFound;
import com.yash.ratings.repo.RatingRepo;
import com.yash.ratings.service.RatingService;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RatingServiceImpl implements RatingService {

    @Autowired
    private RatingRepo repo;

    @Override
    public Rating save(Rating req) {
        String randomId = UUID.randomUUID().toString();
        req.setRatingId(randomId);
        return repo.save(req);
    }

    @Override
    public Rating getRating(String id) {
        return repo.findById(id).orElseThrow(() -> new ResourceNotFound("ResourceNotFound with this findById " + id));
    }

    @Override
    public List<Rating> getAll() {
        return repo.findAll();
    }

    @Override
    public List<Rating> getRatingByUserId(String userId) {
        return repo.findByUserId(userId);
    }

    @Override
    public List<Rating> getRatingByHotelId(String id) {
        return repo.findByHotelId(id);
    }

    @Override
    @Transactional
    public Rating updateRating(String ratingId, Rating newRating) {

        return repo.findById(ratingId).map(existingRating -> {
                    existingRating.setRating(newRating.getRating());
                    existingRating.setUserId(newRating.getUserId());
                    existingRating.setHotelId(newRating.getHotelId());
                    existingRating.setFeedBack(newRating.getFeedBack());

                    return repo.save(existingRating);
                }).
                orElseThrow(() -> new ResourceNotFound("ResourceNotFound with this findById " + ratingId));
//        Optional<Rating> existingRating = repo.findById(ratingId);
//
//        if(existingRating.isEmpty()){
//           throw new ResourceNotFound("ResourceNotFound with this findById "+ ratingId);
//        }
//
//
//        return null;
    }

    @Override
    public void deleteRating(String ratingId) {
        repo.findById(ratingId).ifPresentOrElse(existingRating->{
            repo.deleteById(ratingId);
        }, ()->{
            throw new ResourceNotFound("ResourceNotFound with this findById " + ratingId);
        });
    }
}
