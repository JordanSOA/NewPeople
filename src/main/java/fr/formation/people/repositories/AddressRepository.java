package fr.formation.people.repositories;

import fr.formation.people.entities.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {

    //@Query(value = "SELECT a FROM Address a WHERE a.city LIKE :city")
    List<Address> findByCityContainsIgnoreCase(@Param("city") String city);

}
