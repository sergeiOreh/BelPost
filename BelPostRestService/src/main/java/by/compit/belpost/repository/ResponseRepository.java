package by.compit.belpost.repository;


import by.compit.belpost.entity.City;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ResponseRepository extends JpaRepository<City, Integer> {

    City findByCityId(Integer cityId);

}
