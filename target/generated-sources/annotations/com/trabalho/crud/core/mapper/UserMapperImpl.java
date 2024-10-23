package com.trabalho.crud.core.mapper;

import com.trabalho.crud.core.dto.UserDto;
import com.trabalho.crud.core.entity.User;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-10-23T18:34:45-0300",
    comments = "version: 1.6.2, compiler: Eclipse JDT (IDE) 3.40.0.v20240919-1711, environment: Java 17.0.12 (Eclipse Adoptium)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public User toEntity(UserDto dto) {
        if ( dto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.age( dto.getAge() );
        user.id( dto.getId() );
        user.name( dto.getName() );
        user.ownerEmail( dto.getOwnerEmail() );
        user.ownerName( dto.getOwnerName() );
        user.species( dto.getSpecies() );

        return user.build();
    }

    @Override
    public UserDto toDto(User entity) {
        if ( entity == null ) {
            return null;
        }

        UserDto userDto = new UserDto();

        userDto.setAge( entity.getAge() );
        userDto.setId( entity.getId() );
        userDto.setName( entity.getName() );
        userDto.setOwnerEmail( entity.getOwnerEmail() );
        userDto.setOwnerName( entity.getOwnerName() );
        userDto.setSpecies( entity.getSpecies() );

        return userDto;
    }
}
