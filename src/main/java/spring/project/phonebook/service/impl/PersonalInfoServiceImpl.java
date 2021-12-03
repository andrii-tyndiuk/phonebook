package spring.project.phonebook.service.impl;

import org.springframework.stereotype.Service;
import spring.project.phonebook.dto.request.PersonalInfoRequestDto;
import spring.project.phonebook.dto.response.PersonalInfoResponseDto;
import spring.project.phonebook.model.PersonalInfo;
import spring.project.phonebook.repository.PersonalInfoRepository;
import spring.project.phonebook.service.PersonalInfoService;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Service
public class PersonalInfoServiceImpl implements PersonalInfoService {
    private PersonalInfoRepository personalInfoRepository;
    private RequestDtoMapper<PersonalInfo, PersonalInfoRequestDto> personalInfoRequestDtoMapper;
    private ResponseDtoMapper<PersonalInfo, PersonalInfoResponseDto> personalInfoResponseDtoMapper;

    public PersonalInfoServiceImpl(PersonalInfoRepository personalInfoRepository, RequestDtoMapper<PersonalInfo, PersonalInfoRequestDto> personalInfoRequestDtoMapper, ResponseDtoMapper<PersonalInfo, PersonalInfoResponseDto> personalInfoResponseDtoMapper) {
        this.personalInfoRepository = personalInfoRepository;
        this.personalInfoRequestDtoMapper = personalInfoRequestDtoMapper;
        this.personalInfoResponseDtoMapper = personalInfoResponseDtoMapper;
    }

    @Override
    public PersonalInfoResponseDto save(PersonalInfoRequestDto personalInfoRequestDto) {
        return personalInfoResponseDtoMapper
                .toDto(personalInfoRepository.save(personalInfoRequestDtoMapper.toModel(personalInfoRequestDto)));
    }

    @Override
    public PersonalInfoResponseDto getById(Long id) {
        return personalInfoResponseDtoMapper
                .toDto(personalInfoRepository.getById(id));
    }

    @Override
    public PersonalInfoResponseDto update(Long id, PersonalInfoRequestDto personalInfoRequestDto) {
        PersonalInfo personalInfo = personalInfoRequestDtoMapper.toModel(personalInfoRequestDto);
        personalInfo.setId(id);
        return personalInfoResponseDtoMapper
                .toDto(personalInfoRepository.save(personalInfo));
    }

    @Override
    public void delete(Long id) {
        personalInfoRepository.deleteById(id);
    }
}
