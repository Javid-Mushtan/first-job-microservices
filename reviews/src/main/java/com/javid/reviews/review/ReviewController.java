package com.javid.reviews.review;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {

    @Autowired
    private ReviewService reviewService;

    @GetMapping
    public ResponseEntity<List<Review>> findByCompany(@RequestParam Long companyId) {
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId,
                                            @RequestBody Review review) {
        boolean isReviewSaved = reviewService.addReview(companyId,review);

        if(isReviewSaved){
            return new ResponseEntity<>("Review Added Successfully", HttpStatus.OK);
        }
        return new ResponseEntity<>("Review unsuccessfully", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long companyId, @PathVariable Long reviewId) {
        return new ResponseEntity<>(reviewService.getReview(companyId,reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReview(@PathVariable Long reviewId, @RequestBody Review review) {
        boolean isReviewSaved = reviewService.updateReview(reviewId,review);
        return isReviewSaved ? new ResponseEntity<>("Review Successfully Updated", HttpStatus.OK) : new ResponseEntity<>("Review Unsuccessfully Updated! ", HttpStatus.NOT_ACCEPTABLE);
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId) {
        boolean isReviewSaved = reviewService.deleteReview(reviewId);
        return isReviewSaved ? new ResponseEntity<>("Review Successfully Deleted", HttpStatus.OK) : new ResponseEntity<>("Review Unsuccessfully Deleted! ", HttpStatus.NOT_ACCEPTABLE);
    }
}