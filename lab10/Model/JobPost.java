package com.example.lab10.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@Entity
public class JobPost {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer jobPostId;


    @NotEmpty(message = " title can not be null")
    @Size(min = 5,message = " length of title must be more than 4")
    @Column(columnDefinition = "varchar(20) not null")
    private String title;


    @NotEmpty(message = " description can not be null")
    @Column(columnDefinition = "varchar(100) not null")
    private String description;

    @NotNull(message = " salary can not be null")
    @Column(columnDefinition = "double not null")
    private double salary;

    @NotEmpty(message = " location can not be null")
    @Column(columnDefinition = "varchar(20) not null")
    private String location;


    @NotNull(message = " post date can not be null")
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(columnDefinition = "datetime not null")
    private LocalDate postingDate;
}


