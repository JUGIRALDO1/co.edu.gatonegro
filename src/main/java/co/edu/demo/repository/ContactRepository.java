package co.edu.demo.repository;

import co.edu.demo.model.dto.ContactDTO;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Repository;
import org.springframework.util.ResourceUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class ContactRepository implements IContactRepository{

    private List<ContactDTO> contacts;

    public ContactRepository(){contacts =loadContactData();}

    private List<ContactDTO> loadContactData() {
        File file =null;
        try{
            file = ResourceUtils.getFile("classpath:contacts.json");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        List<ContactDTO> contactDTOList =null;
        try{
            ObjectMapper objectMapper =new ObjectMapper();
            TypeReference<List<ContactDTO>> typeRef = new TypeReference<>() {};
            contactDTOList = objectMapper.readValue(file,typeRef);
        }  catch (Exception e) {
            e.printStackTrace();
        }
        return contactDTOList;
    }

    ;
    @Override
    public ContactDTO GetContact(Integer id) {
        return contacts.stream().
                filter( c -> c.getId().equals(id))
                .findFirst().orElseThrow(()-> new RuntimeException());
    }

    @Override
    public ContactDTO CreateContact(ContactDTO contact) {
        contacts.add(contact);
        return contact;
    }

    @Override
    public ContactDTO UpdateContact(Integer id, ContactDTO contact) {
        ContactDTO oldContact= contacts.stream().
                filter( c -> c.getId().equals(id)).
                findFirst().orElseThrow(()-> new RuntimeException());
        contacts.remove(oldContact);
        contacts.add(contact);
        return contact;
    }

    @Override
    public String DeleteContact(Integer id) {
        ContactDTO contact= contacts.stream().
                filter( c -> c.getId().equals(id)).
                findFirst().orElseThrow(()-> new RuntimeException());
        contacts.remove(contact);
        return "Deleted";
    }
}
