package com.example.entity;


import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="deparments")
@Data
@NoArgsConstructor
public class Department {

    @Id
    private String deparment;
    private String division;
}
