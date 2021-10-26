package co.edu.demo.service;

import co.edu.demo.model.dto.ContactDTO;
import co.edu.demo.repository.IContactRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class ContactServiceUnitTest {

    @Mock
    IContactRepository contactRepository;

    @InjectMocks
    ContactService contactService;
    
    @Test
    public void testGetContactSuccessful(){
        //Arrange
        ContactDTO expectedContact = new ContactDTO(1, "Gabo", "123","Avenida siempre viva");
        Mockito.when(contactRepository.GetContact(1)).thenReturn(expectedContact);

        //Act
        ContactDTO actualContact = contactService.GetContact(1);

        //Assert
        Mockito.verify(contactRepository, Mockito.atLeastOnce()).GetContact(1);
        Assertions.assertEquals(expectedContact.getName(),actualContact.getName());
    }
}
