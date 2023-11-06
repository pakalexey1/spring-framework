package com.example.entity;


import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="departments")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private String department;
    private String division;
}
