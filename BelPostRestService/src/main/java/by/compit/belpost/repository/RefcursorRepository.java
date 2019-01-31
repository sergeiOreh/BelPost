package by.compit.belpost.repository;

import by.compit.belpost.entity.Response;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.*;
import java.util.List;

@Repository
@Transactional
public class RefcursorRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Response> getResponse(String code) {

        TypedQuery<Response> query = entityManager.createNamedQuery("functionCall", Response.class);
        query.setParameter(0,code);
        List<Response> responses = query.getResultList();

        responses.forEach(System.out::println);

        return responses;

    }


}
