package com.propertymanagement.Model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="property")
@Getter
@Setter
@NoArgsConstructor
public class PropertyEntity {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private Long id;
    private String title;
    private String description;
    private Double price;
    private String address;


}
