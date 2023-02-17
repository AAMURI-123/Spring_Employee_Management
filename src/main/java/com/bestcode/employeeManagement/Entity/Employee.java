package com.bestcode.employeeManagement.Entity;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee")
@Getter
@Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "identification_number")
    private String identificationNumber;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "salary")
    private Integer salary;

    @Column(name = "experience_years")
    private Integer experienceYears;

    @Column(name = "email")
    private String email;

    @Column(name = "phone_no")
    private String phoneNo;

    @Column(name = "image_url")
    private String imageUrl;

    @Column(name = "started_date")
    @CreationTimestamp
    private Date startedDate;

    @Column(name = "updated_date")
    @UpdateTimestamp
    private Date updatedDate;

    @ManyToOne
    @JoinColumn(name = "dept_id")
    private Department departmentId;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "employee")
    private Address address;


}
