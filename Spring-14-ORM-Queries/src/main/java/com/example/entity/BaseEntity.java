package com.example.entity;

import javax.persistence.*;

@MappedSuperclass
public class BaseEntity {

    @Id
    private Long id;
}
