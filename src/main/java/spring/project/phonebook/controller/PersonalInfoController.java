package spring.project.phonebook.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.project.phonebook.dto.request.PersonalInfoRequestDto;
import spring.project.phonebook.dto.response.PersonalInfoResponseDto;
import spring.project.phonebook.service.PersonalInfoService;

@RestController
@RequestMapping("/personal-info")
public class PersonalInfoController {
    private PersonalInfoService personalInfoService;

    public PersonalInfoController(PersonalInfoService personalInfoService) {
        this.personalInfoService = personalInfoService;
    }

    @PostMapping("/add")
    public PersonalInfoResponseDto save(@RequestBody PersonalInfoRequestDto personalInfoRequestDto) {
        return personalInfoService.save(personalInfoRequestDto);
    }

    @GetMapping("/{id}")
    public PersonalInfoResponseDto getById(@PathVariable Long id)  {
        return personalInfoService.getById(id);
    }

    @PutMapping("/update/{id}")
    public PersonalInfoResponseDto update(@PathVariable Long id, @RequestBody PersonalInfoRequestDto requestDto) {
        return personalInfoService.update(id, requestDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        personalInfoService.delete(id);
    }
}
