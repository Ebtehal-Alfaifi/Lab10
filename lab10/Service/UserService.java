package com.example.lab10.Service;

import com.example.lab10.Model.User;
import com.example.lab10.Repository.UserRepostry;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class UserService {
    private final UserRepostry userRepostry;

    public List<User>getAll(){
        return userRepostry.findAll();
    }

    public void add(User user){
        userRepostry.save(user);

    }

    public Boolean update(Integer id ,User user){
        User old=userRepostry.findById(id).orElse(null);
        if (old==null) {

            return false;
        }
        old.setName(user.getName());
        old.setEmail(user.getEmail());
        old.setPassword(user.getPassword());
        old.setAge(user.getAge());
        old.setRole(user.getRole());
        userRepostry.save(old);
        return true;
    }

    public Boolean delete(Integer id){
            User old = userRepostry.findById(id).orElse(null);
            if (old == null) {
                return false;
            }
            userRepostry.delete(old);
            return true;
        }

    }



