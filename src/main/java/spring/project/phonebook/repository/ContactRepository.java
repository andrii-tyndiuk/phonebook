package spring.project.phonebook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.project.phonebook.model.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long> {
    @Query(value = "SELECT c FROM Contact c left join fetch c.methodOfCommunication "
            + "left join fetch c.personalInfo Where c.id = ?1")
    Contact getFullById(Long id);
}
