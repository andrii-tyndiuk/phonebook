package spring.project.phonebook.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.phonebook.dto.request.ContactRequestDto;
import spring.project.phonebook.dto.response.ContactFullResponseDto;
import spring.project.phonebook.dto.response.ContactResponseDto;
import spring.project.phonebook.service.ContactService;

@RestController
@RequestMapping("/contact")
public class ContactController {
private ContactService contactService;

    public ContactController(ContactService contactService) {
        this.contactService = contactService;
    }

    @PostMapping("/add")
    public ContactResponseDto create(@RequestBody ContactRequestDto contactRequestDto) {
        return contactService.save(contactRequestDto);
    }

    @GetMapping("/{id}")
    public ContactFullResponseDto get(@PathVariable Long id) {
        return contactService.get(id);
    }

    @GetMapping
    public List<ContactResponseDto> getAll() {
        return contactService.findAll();
    }

    @PutMapping("/update/{id}")
    public ContactResponseDto update(@PathVariable Long id,
                                     @RequestBody ContactRequestDto contactRequestDto) {
        return contactService.update(id, contactRequestDto);
    }

    //need some fix
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        contactService.deleteById(id);
    }
}
