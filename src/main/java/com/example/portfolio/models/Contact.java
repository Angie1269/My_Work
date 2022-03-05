package com.example.portfolio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String emailFrom;
    private String emailText;

    @ManyToOne
    private User user;

    public Contact(Long id, String emailFrom, String emailText) {
        this.id = id;
        this.emailFrom = emailFrom;
        this.emailText = emailText;
    }
}
