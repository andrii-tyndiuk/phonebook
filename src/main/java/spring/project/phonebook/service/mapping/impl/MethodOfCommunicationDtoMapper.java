package spring.project.phonebook.service.mapping.impl;

import org.springframework.stereotype.Component;
import spring.project.phonebook.dto.request.MethodOfCommunicationRequestDto;
import spring.project.phonebook.dto.response.MethodOfCommunicationResponseDto;
import spring.project.phonebook.model.MethodOfCommunication;
import spring.project.phonebook.repository.ContactRepository;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Component
public class MethodOfCommunicationDtoMapper
        implements RequestDtoMapper<MethodOfCommunication, MethodOfCommunicationRequestDto>,
        ResponseDtoMapper<MethodOfCommunication, MethodOfCommunicationResponseDto> {
    private ContactRepository contactRepository;

    public MethodOfCommunicationDtoMapper(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public MethodOfCommunication toModel(MethodOfCommunicationRequestDto dto) {
        MethodOfCommunication moc = new MethodOfCommunication();
        moc.setCommunicationType(dto.getCommunicationType());
        moc.setNumber(dto.getNumber());
        moc.setDescription(dto.getDescription());
        moc.setContact(contactRepository.findById(dto.getContactId()).orElseThrow());
        return moc;
    }

    @Override
    public MethodOfCommunicationResponseDto toDto(MethodOfCommunication model) {
        MethodOfCommunicationResponseDto dto = new MethodOfCommunicationResponseDto();
        dto.setId(model.getId());
        dto.setCommunicationType(model.getCommunicationType().toString());
        dto.setDescription(model.getDescription());
        dto.setNumber(model.getNumber());
        dto.setContactId(model.getContact().getId());
        return dto;
    }
}
