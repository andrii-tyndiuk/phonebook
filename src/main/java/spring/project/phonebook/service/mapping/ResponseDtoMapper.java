package spring.project.phonebook.service.mapping;

public interface ResponseDtoMapper <M, D> {
    D toDto(M model);
}
