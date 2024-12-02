package com.example.lab10.Repository;

import com.example.lab10.Model.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface JobApplicationRepo extends JpaRepository<JobApplication,Integer> {
    boolean existsByUserIdAndJobPostId(Integer userId, Integer jobPostId);
    Optional<JobApplication> findByUserIdAndJobPostId(Integer userId, Integer jobPostId);

}
