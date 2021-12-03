package spring.project.phonebook.service;

import java.util.List;
import spring.project.phonebook.dto.request.ContactRequestDto;
import spring.project.phonebook.dto.response.ContactFullResponseDto;
import spring.project.phonebook.dto.response.ContactResponseDto;

public interface ContactService {
    ContactResponseDto save(ContactRequestDto contactRequestDto);

    ContactFullResponseDto get(Long id);

    List<ContactResponseDto> findAll();

    ContactResponseDto update(Long id, ContactRequestDto contactRequestDto);

    void deleteById(Long id);
}
