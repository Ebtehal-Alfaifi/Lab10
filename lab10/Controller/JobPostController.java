package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.Api;
import com.example.lab10.Model.JobPost;
import com.example.lab10.Service.JobPostService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Job_post")
public class JobPostController {


    private final JobPostService jobPostService;


    @GetMapping("/get")
    public ResponseEntity getAllJobPosts() {
      List<JobPost> list=jobPostService.getAll();
        return ResponseEntity.status(200).body(list);
    }

    @PostMapping("/add")
    public ResponseEntity addJobPost(@RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        jobPostService.add(jobPost);
        return ResponseEntity.status(200).body(new Api("Job post added successfully"));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<String> updateJobPost(@PathVariable Integer id, @RequestBody @Valid JobPost jobPost, Errors errors) {
        if (errors.hasErrors()) {
            String message = errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(400).body(message);
        }
        Boolean isUpdated = jobPostService.update(id, jobPost);
        if (!isUpdated) {
            return ResponseEntity.status(400).body(new Api("Job post not found or update failed").getMessage());
        }
        return ResponseEntity.status(200).body(new Api("Job post updated successfully").getMessage());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteJobPost(@PathVariable Integer id) {
        Boolean isDeleted = jobPostService.delete(id);
        if (!isDeleted) {
            return ResponseEntity.status(400).body(new Api("Job post not found").getMessage());
        }
        return ResponseEntity.status(200).body(new Api("Job post deleted successfully").getMessage());
    }





}
