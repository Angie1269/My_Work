package com.example.portfolio.services;

import com.example.portfolio.models.Contact;


import java.util.List;

public interface ContactService {


    List<Contact> getAllContact();

    void saveContact(Contact contact);

    Contact getContactById(int id);

}
