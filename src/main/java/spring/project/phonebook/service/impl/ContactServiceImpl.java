package spring.project.phonebook.service.impl;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;
import spring.project.phonebook.dto.request.ContactRequestDto;
import spring.project.phonebook.dto.response.ContactFullResponseDto;
import spring.project.phonebook.dto.response.ContactResponseDto;
import spring.project.phonebook.model.Contact;
import spring.project.phonebook.repository.ContactRepository;
import spring.project.phonebook.service.ContactService;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Service
public class ContactServiceImpl implements ContactService {
    private RequestDtoMapper<Contact, ContactRequestDto> requestDtoMapper;
    private ResponseDtoMapper<Contact, ContactResponseDto> responseDtoMapper;
    private ResponseDtoMapper<Contact, ContactFullResponseDto> fullResponseDtoMapper;
    private ContactRepository contactRepository;

    public ContactServiceImpl(RequestDtoMapper<Contact, ContactRequestDto> requestDtoMapper,
                              ResponseDtoMapper<Contact, ContactResponseDto> responseDtoMapper,
                              ResponseDtoMapper<Contact, ContactFullResponseDto> fullResponseDtoMapper,
                              ContactRepository contactRepository) {
        this.requestDtoMapper = requestDtoMapper;
        this.responseDtoMapper = responseDtoMapper;
        this.fullResponseDtoMapper = fullResponseDtoMapper;
        this.contactRepository = contactRepository;
    }

    @Override
    public ContactResponseDto save(ContactRequestDto contactRequestDto) {
        return responseDtoMapper
                .toDto(contactRepository.save(requestDtoMapper.toModel(contactRequestDto)));
    }

    @Override
    public ContactFullResponseDto get(Long id) {
        return fullResponseDtoMapper.toDto(contactRepository.getFullById(id));
    }

    @Override
    public List<ContactResponseDto> findAll() {
        return contactRepository.findAll().stream().map(responseDtoMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public ContactResponseDto update(Long id, ContactRequestDto contactRequestDto) {
        Contact contact = requestDtoMapper.toModel(contactRequestDto);
        contact.setId(id);
        return responseDtoMapper.toDto(contact);
    }

    @Override
    public void deleteById(Long id) {
        contactRepository.deleteById(id);
    }


}
