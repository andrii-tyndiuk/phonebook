package spring.project.phonebook.service;

import spring.project.phonebook.dto.request.PersonalInfoRequestDto;
import spring.project.phonebook.dto.response.PersonalInfoResponseDto;

public interface PersonalInfoService {

    PersonalInfoResponseDto save(PersonalInfoRequestDto personalInfoRequestDto);

    PersonalInfoResponseDto getById(Long id);

    PersonalInfoResponseDto update(Long id, PersonalInfoRequestDto personalInfoRequestDto);

    void delete(Long id);
}
