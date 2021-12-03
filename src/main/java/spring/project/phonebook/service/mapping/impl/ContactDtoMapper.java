package spring.project.phonebook.service.mapping.impl;

import org.springframework.stereotype.Component;
import spring.project.phonebook.dto.request.ContactRequestDto;
import spring.project.phonebook.dto.response.ContactResponseDto;
import spring.project.phonebook.model.Contact;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Component
public class ContactDtoMapper implements RequestDtoMapper<Contact, ContactRequestDto>,
        ResponseDtoMapper<Contact, ContactResponseDto> {
    @Override
    public Contact toModel(ContactRequestDto dto) {
        Contact contact = new Contact();
        contact.setNickname(dto.getNickname());
        contact.setPhoneNumber(dto.getPhoneNumber());
        contact.setContactType(Contact.ContactType.valueOf(dto.getContactType()));
        return contact;
    }

    @Override
    public ContactResponseDto toDto(Contact model) {
        ContactResponseDto dto = new ContactResponseDto();
        dto.setId(model.getId());
        dto.setNickname(model.getNickname());
        dto.setPhoneNumber(model.getPhoneNumber());
        dto.setContactType(model.getContactType().toString());
        return dto;
    }
}
