package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity

//▪ userId:
//- Cannot be null. ▪ jobPostId:
//- Cannot be nul
public class JobApplication {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer JobAppid;

    @NotNull(message = " user id can not be null")
    @Column(columnDefinition = "int not null")
     private Integer userId;


    @NotNull(message = "jobPostId can not be null")
    @Column(columnDefinition = "int not null")
    private Integer jobPostId;


}
