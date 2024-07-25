package com.cleanarchitecture.techchallenge.persistence.entities;

import com.cleanarchitecture.techchallenge.persistence.utils.StringListConverter;
import com.cleanarchitecture.techchallenge.domain.entities.Email;
import com.cleanarchitecture.techchallenge.domain.entities.user.User;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_users")
@Builder(setterPrefix = "with")
public class UserEntity {


    @Id
    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    private String name;
    private String password;

    @Convert(converter = StringListConverter.class)
    private List<String> role;

    public static UserEntity toEntity(User user) {
        return user == null
                ? null
                : UserEntity
                .builder()
                .withUsername(user.getUsername())
                .withEmail(user.getEmail().email())
                .withName(user.getName())
                .withPassword(user.getPassword())
                .withRole(user.getRoles())
                .build();
    }

    public static User toDomain(UserEntity user) {
        return user == null
                ? null
                : new User
                (
                        user.getName(),
                        new Email(user.getEmail()),
                        user.getUsername(),
                        user.getPassword(),
                        user.getRole()
                );
    }
}
