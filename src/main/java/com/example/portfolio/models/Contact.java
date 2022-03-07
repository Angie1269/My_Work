package com.example.portfolio.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;


@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Integer id;
    private String name;
    private String message;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDateTime creationDate = LocalDateTime.now();

    @ManyToOne(cascade = CascadeType.ALL)

    private User user;


    public Contact(String name, String message) {
        this.name = name;
        this.message = message;
    }

    public long timeDifferenceInMinutes() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.MINUTES.between(now, creationDate) / -1;
    }

    public long timeDifferenceInHours() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.HOURS.between(now, creationDate) / -1;
    }

    public long timeDifferenceInDays() {
        LocalDateTime now = LocalDateTime.now();
        return ChronoUnit.DAYS.between(now, creationDate) / -1;
    }

    public String getTimeDifference() {
        if (timeDifferenceInMinutes() < 2) {
            return "Posted contact now";
        } else if (timeDifferenceInMinutes() < 60) {
            return "Posted contact " + timeDifferenceInMinutes() + " minutes ago";
        } else if (timeDifferenceInHours() < 24) {
            return "Posted contact " + timeDifferenceInHours() + " hours ago";
        } else {
            return "Posted contact " + timeDifferenceInDays() + " days ago";
        }
    }
}
