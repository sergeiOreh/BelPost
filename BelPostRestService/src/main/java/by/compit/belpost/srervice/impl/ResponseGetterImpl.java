package by.compit.belpost.srervice.impl;

import by.compit.belpost.repository.RefcursorRepository;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ResponseGetterImpl implements ResponseGetter {

    private final RefcursorRepository refcursorRepository;

    @Autowired
    public ResponseGetterImpl(RefcursorRepository refcursorRepository) {
        this.refcursorRepository = refcursorRepository;
    }

    @Override
    public JSONArray getResponseByCodes(ArrayList<String> codes) {

        JSONArray response = new JSONArray();

        for (String code : codes) {
            response.put(refcursorRepository.getResponse(code));
        }

        return response;
    }
}
