package spring.project.phonebook.service.mapping.impl;

import org.springframework.stereotype.Component;
import spring.project.phonebook.dto.request.CallRequestDto;
import spring.project.phonebook.dto.response.CallResponseDto;
import spring.project.phonebook.model.OurCall;
import spring.project.phonebook.repository.ContactRepository;
import spring.project.phonebook.service.mapping.RequestDtoMapper;
import spring.project.phonebook.service.mapping.ResponseDtoMapper;

@Component
public class CallDtoMapper implements RequestDtoMapper<OurCall, CallRequestDto>,
        ResponseDtoMapper<OurCall, CallResponseDto> {
    private ContactRepository contactRepository;

    public CallDtoMapper(ContactRepository contactRepository) {
        this.contactRepository = contactRepository;
    }


    @Override
    public OurCall toModel(CallRequestDto dto) {
        OurCall call = new OurCall();
        call.setType(OurCall.Type.valueOf(dto.getType()));
        call.setTime(dto.getTime());
        call.setDuration(dto.getDuration());
        call.setFromContact(contactRepository.findById(dto.getFromContactId()).orElseThrow());
        call.setToContact(contactRepository.findById(dto.getToContactId()).orElseThrow());
        return call;
    }

    @Override
    public CallResponseDto toDto(OurCall model) {
        CallResponseDto callResponseDto = new CallResponseDto();
        callResponseDto.setId(model.getId());
        callResponseDto.setType(model.getType());
        callResponseDto.setTime(model.getTime());
        callResponseDto.setDuration(model.getDuration());
        callResponseDto.setFromContactId(model.getFromContact().getId());
        callResponseDto.setToContactId(model.getToContact().getId());
        return callResponseDto;
    }
}
