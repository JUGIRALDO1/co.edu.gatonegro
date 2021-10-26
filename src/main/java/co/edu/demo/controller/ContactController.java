package co.edu.demo.controller;

import co.edu.demo.model.dto.ContactDTO;
import co.edu.demo.service.IContactService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class ContactController {

    private final IContactService contactService;

    @GetMapping("/status")
    public ResponseEntity<ContactDTO> getStatus() {
        return new ResponseEntity<>(HttpStatus.OK);
    }

    // GET
    @GetMapping("/contact")
    public ResponseEntity<ContactDTO> getContact(@RequestParam Integer id) {
        return new ResponseEntity<>(contactService.GetContact(id), HttpStatus.OK);
    }

    // POST
    @PostMapping("/contact")
    public ResponseEntity<ContactDTO> CreateContact(@RequestBody ContactDTO contact) {
        return new ResponseEntity<>(contactService.CreateContact(contact), HttpStatus.CREATED);
    }

    // PUT
    @PutMapping("/contact")
    public ResponseEntity<ContactDTO> UpdateContact(@RequestParam Integer id, @RequestBody ContactDTO contact) {
        return new ResponseEntity<>(contactService.UpdateContact(id, contact), HttpStatus.OK);
    }

    // DELETE
    @DeleteMapping("/contact")
    public ResponseEntity<String> DeleteContact(@RequestParam Integer id) {
        return new ResponseEntity<>(contactService.DeleteContact(id), HttpStatus.OK);
    }
}
