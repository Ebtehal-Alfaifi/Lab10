package com.example.lab10.Service;

import com.example.lab10.Model.JobPost;
import com.example.lab10.Repository.JobPostRepstry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class JobPostService {
    private final JobPostRepstry jobPostRepstry;

    public List<JobPost> getAll(){
        return jobPostRepstry.findAll();
    }

    public void add(JobPost jobPost){
        jobPostRepstry.save(jobPost);

    }

    public Boolean update(Integer id ,JobPost jobPost){
        JobPost old=jobPostRepstry.findById(id).orElse(null);
        if (old==null) {

            return false;
        }
       old.setTitle(jobPost.getTitle());
        old.setDescription(jobPost.getDescription());
        old.setLocation(jobPost.getLocation());
        old.setPostingDate(jobPost.getPostingDate());
        old.setSalary(jobPost.getSalary());
        jobPostRepstry.save(old);
        return true;
    }

    public Boolean delete(Integer id){
        JobPost old = jobPostRepstry.findById(id).orElse(null);
        if (old == null) {
            return false;
        }
        jobPostRepstry.delete(old);
        return true;
    }

}
