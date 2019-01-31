package by.compit.belpost.srervice.impl;

import by.compit.belpost.repository.RefcursorRepository;
import by.compit.belpost.repository.ResponseRepository;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ResponseGetterImpl implements ResponseGetter {

    private final ResponseRepository responseRepository;
    private final RefcursorRepository refcursorRepository;

    @Autowired
    public ResponseGetterImpl(ResponseRepository responseRepository, RefcursorRepository refcursorRepository) {
        this.responseRepository = responseRepository;
        this.refcursorRepository = refcursorRepository;
    }

    @Override
    public JSONArray getResponseByCityId(Integer id) {
        JSONArray response = new JSONArray();
        response.put(responseRepository.findByCityId(id));
        return response;
    }

    @Override
    public JSONArray getResponseByCode(String code) {
        JSONArray response = new JSONArray();
        response.put(refcursorRepository.getResponse(code));
        return response;
    }
}
