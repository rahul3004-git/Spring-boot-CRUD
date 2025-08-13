package com.springboot.cruddemo.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "student")
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "First Name is required") // only for strings not for numbers
    @Size(min = 3, max = 50, message = "Name must be between 3 and 50 characters") // only for strings not for numbers
    private String firstName;

    @NotBlank
    private String lastName;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;

    @NotNull(message = "Age is required")
    @Min(value = 18,message = "Age should be above 18")
    @Max(value = 100,message = "Age should be below 100")
    private Integer age;

//    @NotNull(message = "Phone number is required")
//    @Column(unique = true)
    private Long phoneNumber;

    @CreationTimestamp
    private LocalDateTime timestamp;

    @UpdateTimestamp
    private LocalDateTime updatedTimeStamp;
}
