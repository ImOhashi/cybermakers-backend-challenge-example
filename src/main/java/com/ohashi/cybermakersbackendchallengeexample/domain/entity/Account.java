package com.ohashi.cybermakersbackendchallengeexample.domain.entity;

import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Account {
    private Integer branch;
    private Long number;
    private Double balance;
}
