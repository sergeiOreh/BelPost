package by.compit.belpost.srervice.impl;

import by.compit.belpost.repository.ResponseRepository;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseGetterImpl implements ResponseGetter {

    private final ResponseRepository responseRepository;

    @Autowired
    public ResponseGetterImpl(ResponseRepository responseRepository) {
        this.responseRepository = responseRepository;
    }

    @Override
    public JSONArray getResponseByCityId(Integer id) {

        System.out.println("ResponseGetterImpl=>");
        System.out.println("id" + id);

        JSONArray response = new JSONArray();

        response.put(responseRepository.findByCityId(id));

        System.out.println("response" + response);

        return response;
    }
}
