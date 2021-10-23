package co.edu.demo.repository;

import co.edu.demo.model.dto.ContactDTO;

public interface IContactRepository {
    ContactDTO GetContact(Integer id);

    ContactDTO CreateContact(ContactDTO contact);

    ContactDTO UpdateContact(Integer id, ContactDTO contact);

    String DeleteContact(Integer id);
}
