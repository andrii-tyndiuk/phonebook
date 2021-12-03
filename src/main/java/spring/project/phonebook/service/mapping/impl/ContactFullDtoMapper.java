package spring.project.phonebook.service.mapping.impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import org.springframework.stereotype.Component;
import spring.project.phonebook.dto.response.ContactFullResponseDto;
import spring.project.phonebook.dto.response.MethodOfCommunicationResponseDto;
import spring.project.phonebook.dto.response.PersonalInfoResponseDto;
import spring.project.phonebook.model.Contact;
import spring.project.phonebook.model.MethodOfCommunication;
import spring.project.phonebook.model.PersonalInfo;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Component
public class ContactFullDtoMapper implements ResponseDtoMapper<Contact, ContactFullResponseDto> {
    private final ResponseDtoMapper<MethodOfCommunication, MethodOfCommunicationResponseDto>
            methodOfCommunicationResponseDtoMapper;
    private final ResponseDtoMapper<PersonalInfo, PersonalInfoResponseDto> personalInfoResponseDtoMapper;

    public ContactFullDtoMapper(ResponseDtoMapper<MethodOfCommunication, MethodOfCommunicationResponseDto>
                                        methodOfCommunicationResponseDtoMapper, ResponseDtoMapper<PersonalInfo, PersonalInfoResponseDto> personalInfoResponseDtoMapper) {
        this.methodOfCommunicationResponseDtoMapper = methodOfCommunicationResponseDtoMapper;
        this.personalInfoResponseDtoMapper = personalInfoResponseDtoMapper;
    }

    @Override
    public ContactFullResponseDto toDto(Contact model) {
        ContactFullResponseDto dto = new ContactFullResponseDto();
        dto.setId(model.getId());
        dto.setNickname(model.getNickname());
        dto.setPhoneNumber(model.getPhoneNumber());
        dto.setContactType(model.getContactType().toString());
        Optional<List<MethodOfCommunication>> optional = Optional.ofNullable(model.getMethodOfCommunication());
        optional.ifPresent(o -> dto.setMethodOfCommunication(o.stream()
                .map(methodOfCommunicationResponseDtoMapper::toDto)
                .collect(Collectors.toList())));
        dto.setPersonalInfo(personalInfoResponseDtoMapper.toDto(model.getPersonalInfo()));
        return dto;
    }
}
