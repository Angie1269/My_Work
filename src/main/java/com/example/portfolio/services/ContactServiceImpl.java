package com.example.portfolio.services;

import com.example.portfolio.models.Contact;
import com.example.portfolio.repositories.ContactRepositorie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactServiceImpl implements ContactService {
    private final ContactRepositorie contactRepositorie;

    @Autowired
    public ContactServiceImpl(ContactRepositorie contactRepositorie) {

        this.contactRepositorie = contactRepositorie;
    }


    @Override
    public List<Contact> getAllContact() {
        return contactRepositorie.findAll();
    }

    @Override
    public void saveContact(Contact contact) {
        contactRepositorie.save(contact);

    }

    @Override
    public Contact getContactById(int id) {
        return contactRepositorie.getById(id);
    }
}
