package com.example.portfolio.repositories;

import com.example.portfolio.models.Contact;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactRepositorie extends JpaRepository<Contact, Integer> {

}
