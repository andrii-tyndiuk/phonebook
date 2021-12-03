package spring.project.phonebook.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import spring.project.phonebook.model.MethodOfCommunication;

@Repository
public interface MethodOfCommunicationRepository extends JpaRepository<MethodOfCommunication, Long> {
    @Query(value = "SELECT * FROM Method_Of_Communication m  WHERE contact_id = :id", nativeQuery = true)
    List<MethodOfCommunication> getByContactId(@Param("id")Long contactId);

    @Query(value = "SELECT * FROM Method_Of_Communication m  WHERE contact_id = :id AND communication_type = :type", nativeQuery = true)
    List<MethodOfCommunication> getByContactIdAndType(@Param("id")Long contactId, @Param("type")String type);
}
