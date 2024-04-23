package com.ohashi.cybermakersbackendchallengeexample.domain.entity;

import com.ohashi.cybermakersbackendchallengeexample.domain.entity.enums.PersonType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import org.bson.types.ObjectId;
import org.hibernate.validator.constraints.br.CNPJ;
import org.hibernate.validator.constraints.br.CPF;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.PersistenceCreator;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("person")
public class Person {

    @PersistenceCreator
    public Person(ObjectId _id, String name, String surname, String phone, String email, String taxId, PersonType type, Account account) {
        this._id = _id;
        this.name = name;
        this.surname = surname;
        this.phone = phone;
        this.email = email;
        this.taxId = taxId;
        this.type = type;
        this.account = account;
    }

    @Id
    private ObjectId _id;

    @NotBlank(message = "Name field is mandatory")
    private String name;

    @NotBlank(message = "Surname field is mandatory")
    private String surname;

    @NotBlank(message = "Phone field is mandatory")
    @Size(min = 11, max = 11)
    private String phone;

    @Email(message = "Invalid e-mail")
    @NotBlank(message = "E-mail field is mandatory")
    private String email;

    @CPF
    @CNPJ
    @NotBlank(message = "CPF/CNPJ is mandatory")
    private String taxId;

    @NotBlank(message = "Person type is mandatory")
    private PersonType type;

    private Account account;

    public static class Builder {

    }
}
