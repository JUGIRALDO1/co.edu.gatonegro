package co.edu.demo.service;

import co.edu.demo.model.dto.ContactDTO;
import co.edu.demo.repository.IContactRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ContactService implements IContactService {

    @Autowired
    IContactRepository contactRepository;
    @Override
    public ContactDTO GetContact(Integer id) {
        return contactRepository.GetContact(id);
    }

    @Override
    public ContactDTO CreateContact(ContactDTO contact) {
        return contactRepository.CreateContact(contact);
    }

    @Override
    public ContactDTO UpdateContact(Integer id, ContactDTO contact) {
        return contactRepository.UpdateContact(id,contact);
    }

    @Override
    public String DeleteContact(Integer id) {
        return contactRepository.DeleteContact(id);
    }
}
