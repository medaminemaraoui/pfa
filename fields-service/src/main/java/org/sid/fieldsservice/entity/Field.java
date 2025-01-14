package org.sid.fieldsservice.entity;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity @Data @AllArgsConstructor@NoArgsConstructor

public class Field {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
   // @NotBlank(message = "Field name is required")
    private String name;

    //@NotBlank(message = "Location is required")
    private String location;

    private boolean isAvailable ;




}
