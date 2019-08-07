package pl.coderslab.charity.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.coderslab.charity.entity.Institution;

import java.util.List;

@Repository
public interface InstitutionRepository extends JpaRepository<Institution, Long> {

    List<Institution> findAll();

    @Query("select count(i) from Institution i")
    long institutionsCount();

    Institution findByName(String name);

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query("Update Institution i set i.name = :name, i.description =:description where i.id = :id")
    void updateSetNameAndDescription(@Param("id") Long id, @Param("name") String name, @Param("description") String description);

}
