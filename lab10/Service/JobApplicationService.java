package com.example.lab10.Service;

import com.example.lab10.Model.JobApplication;
import com.example.lab10.Repository.JobApplicationRepo;
import com.example.lab10.Repository.JobPostRepstry;
import com.example.lab10.Repository.UserRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class JobApplicationService {
    private final JobApplicationRepo jobApplicationRepo;
    private final UserRepostry userRepository;
    private final JobPostRepstry jobPostRepository;


    public List<JobApplication> getAll(){
        return jobApplicationRepo.findAll();
    }

// apply for job
    public String applyForJob(Integer userId, Integer jobPostId) {
        if (!userRepository.existsById(userId)) {
            return "User not found";
        }

        if (!jobPostRepository.existsById(jobPostId)) {
            return "Job post not found";
        }

        // عرفت هذه الدالة في الريبو
        // استخدمتها عشان اتحقق اذا المستخدم تقدم على الوظيفة من قبل
        Boolean alreadyApplied = jobApplicationRepo.existsByUserIdAndJobPostId(userId, jobPostId);
        if (alreadyApplied) {
            return "You have already applied for this job";
        }

        JobApplication application = new JobApplication();
        application.setUserId(userId);
        application.setJobPostId(jobPostId);

        jobApplicationRepo.save(application);
        return "Job application submitted successfully";
    }

    // Withdraw Job Application
    public String withdrawJobApplication(Integer userId, Integer jobPostId) {
        // عرفت ميثود الفايند بالريبوزتري
        // نستخدم optional لتخقق من وجود طلب توظيف مطتابق او لا
        Optional<JobApplication> jobApplication = jobApplicationRepo.findByUserIdAndJobPostId(userId, jobPostId);

        if (jobApplication.isEmpty()) {
            return "Job application not found";
        }
      // اذا كان موجود بحذفه
        jobApplicationRepo.delete(jobApplication.get());
        return "Job application withdrawn successfully";
    }
}














