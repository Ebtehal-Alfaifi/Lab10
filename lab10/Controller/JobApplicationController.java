package com.example.lab10.Controller;

import com.example.lab10.ApiResponse.Api;
import com.example.lab10.Model.JobApplication;
import com.example.lab10.Service.JobApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/Job-application")
public class JobApplicationController {
    private final JobApplicationService jobApplicationService;

@GetMapping("/get")
    public ResponseEntity getAll(){
        List<JobApplication> getList=jobApplicationService.getAll();
        return ResponseEntity.status(200).body(getList);
    }


      @PostMapping("/apply/{userId}/{jobPostId}")
      public ResponseEntity applyForJob(@PathVariable Integer userId, @PathVariable Integer jobPostId) {
          String result = jobApplicationService.applyForJob(userId, jobPostId);

          if (result.equals("Job application submitted successfully")) {
              return ResponseEntity.status(200).body(result);
          }
          return ResponseEntity.status(400).body(new Api("you cant applied"));
      }


    @DeleteMapping("/withdraw/{userId}/{jobPostId}")
    public ResponseEntity withdrawJobApplication(@PathVariable Integer userId, @PathVariable Integer jobPostId) {
        String result = jobApplicationService.withdrawJobApplication(userId, jobPostId);

        if (result.equals("Job application withdrawn successfully")) {
            return ResponseEntity.status(200).body(result);
        }

        return ResponseEntity.status(400).body(new Api(" does not found"));
    }
}


