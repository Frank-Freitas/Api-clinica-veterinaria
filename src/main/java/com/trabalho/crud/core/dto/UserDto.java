package com.trabalho.crud.core.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDto {
    private Long id;

    private String name;

    private String species;   
    private int age;       

    private String ownerName; 

    private String ownerEmail;
}
