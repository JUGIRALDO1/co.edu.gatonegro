package co.edu.demo.service;

import co.edu.demo.model.dto.ContactDTO;

public interface IContactService {
    ContactDTO GetContact(Integer id);

    ContactDTO CreateContact(ContactDTO contact);

    ContactDTO UpdateContact(Integer id, ContactDTO contact);

    String DeleteContact(Integer id);
}
