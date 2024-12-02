package com.example.lab10.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;

@Data
@NoArgsConstructor
@Entity
// id:
//- Must be Generated.
//▪ name:
//- Cannot be null.
//- Length must be more than 4 characters.
//- Must contain only characters (no numbers).
//▪ email:
//- Must be a valid email format.
//- Must be unique.
//▪ password:
//- Cannot be null. ▪ age:
//- Cannot be null.
//- Must be a number.
//- Must be more than 21.
//▪ role:
//- Cannot be null.
//- Must be either "JOB_SEEKER" or "EMPLOYER" only.
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;

    @NotEmpty(message = " name can not be null")
    @Size(min = 5 ,message = "name should be  5 character")
    @Column(columnDefinition = "varchar(10) not null")
    private String name;

    @Email(message = " you should enter valid email")
    @NotEmpty(message = " email can not be empty")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String email;


    @NotEmpty(message = "password can not be null")
    @Pattern(regexp ="^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&]).{8,}$",message = "Ensures that the string contains at least one lowercase letter.\n" +
            " Ensures that the string contains at least one uppercase letter.\n" +
            " Ensures that the string contains at least one digit.\n" +
            " Ensures that the string contains at least one special character (like @$!%*?&).\n" +
            " Ensures that the length of the string is at least 8 characters (any characters).")

    @Column(columnDefinition = "varchar(20) not null")
    private String password;



    @NotNull(message = " age can not be null")
    @Min(value = 22,message = " yore age should be more than 21")
    @Column(columnDefinition = "int not null")
    private Integer age;


//▪ role:
//- Cannot be null.
//- Must be either "JOB_SEEKER" or "EMPLOYER" only.

    @NotEmpty(message = " role can not be empty")
    @Pattern(regexp = "^(?i)(JOB_SEEKER|EMPLOYER)$")
@Column(columnDefinition = "varchar(20) not null")
    private String role;
}
