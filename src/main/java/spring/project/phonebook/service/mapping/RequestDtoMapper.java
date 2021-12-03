package spring.project.phonebook.service.mapping;

public interface RequestDtoMapper <M, D>{
    M toModel(D dto);
}
