package com.example.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="regions")
@Data
@NoArgsConstructor
public class Region extends BaseEntity{

    private String region;
    private String country;


}
