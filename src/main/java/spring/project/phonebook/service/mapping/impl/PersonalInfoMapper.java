package spring.project.phonebook.service.mapping.impl;

import org.springframework.stereotype.Component;
import spring.project.phonebook.dto.request.PersonalInfoRequestDto;
import spring.project.phonebook.dto.response.PersonalInfoResponseDto;
import spring.project.phonebook.model.PersonalInfo;
import spring.project.phonebook.repository.ContactRepository;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Component
public class PersonalInfoMapper implements RequestDtoMapper<PersonalInfo, PersonalInfoRequestDto>,
        ResponseDtoMapper<PersonalInfo, PersonalInfoResponseDto> {
    private ContactRepository contactRepository;

    public PersonalInfoMapper(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }

    @Override
    public PersonalInfo toModel(PersonalInfoRequestDto dto) {
        PersonalInfo personalInfo = new PersonalInfo();
        personalInfo.setFirstName(dto.getFirstName());
        personalInfo.setLastName(dto.getLastName());
        personalInfo.setBirthDay(dto.getBirthDay());
        personalInfo.setContact(contactRepository.getById(dto.getContactId()));
        return personalInfo;
    }

    @Override
    public PersonalInfoResponseDto toDto(PersonalInfo model) {
        PersonalInfoResponseDto personalInfoResponseDto = new PersonalInfoResponseDto();
        personalInfoResponseDto.setId(model.getId());
        personalInfoResponseDto.setFirstName(model.getFirstName());
        personalInfoResponseDto.setLastName(model.getLastName());
        personalInfoResponseDto.setBirthDay(model.getBirthDay());
        personalInfoResponseDto.setContactId(model.getContact().getId());
        return personalInfoResponseDto;
    }
}
