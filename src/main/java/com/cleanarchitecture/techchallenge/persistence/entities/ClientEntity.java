package com.cleanarchitecture.techchallenge.persistence.entities;

import com.cleanarchitecture.techchallenge.domain.entities.Cpf;
import com.cleanarchitecture.techchallenge.domain.entities.Email;
import com.cleanarchitecture.techchallenge.domain.entities.client.Client;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import static java.util.Objects.isNull;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "tb_clients")
@Builder(setterPrefix = "with")
public class ClientEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String cpf;

    private String name;
    private String email;

    public static ClientEntity toEntity(Client requester) {
        return requester == null
                ? null
                : ClientEntity
                .builder()
                .withId(requester.getId())
                .withCpf(requester.getCpf().number())
                .withName(requester.getName())
                .withEmail(requester.getEmail().email())
                .build();
    }

    public static Client toDomain(ClientEntity requester) {
        return requester == null
                ? null
                : new Client(requester.getId(),
                new Cpf(requester.getCpf()),
                requester.getName(),
                new Email(requester.getEmail()));
    }
}
