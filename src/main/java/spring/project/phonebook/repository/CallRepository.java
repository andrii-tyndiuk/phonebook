package spring.project.phonebook.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import spring.project.phonebook.model.OurCall;


@Repository
public interface CallRepository extends JpaRepository<OurCall, Long> {
    @Query("SELECT c FROM OurCall c left join fetch c.fromContact con1 " +
            "left join fetch c.toContact con2 WHERE con1.id = ?1 or con2.id =?1")
    List<OurCall> findAllCallByContactId(Long contactId);

}