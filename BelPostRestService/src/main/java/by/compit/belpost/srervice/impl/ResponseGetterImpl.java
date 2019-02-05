package by.compit.belpost.srervice.impl;

import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.repository.impl.RefcursorRepositoryImpl;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;

/**
 * Класс ResponseGetterImpl содержит реализацию методов по нахождению ответов в формате {@link JSONArray}.
 */
@Component
public class ResponseGetterImpl implements ResponseGetter {

    private final RefcursorRepositoryImpl refcursorRepositoryImpl;

    @Autowired
    public ResponseGetterImpl(RefcursorRepositoryImpl refcursorRepositoryImpl) {
        this.refcursorRepositoryImpl = refcursorRepositoryImpl;
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public JSONArray getResponseByPo(String code) throws NotFoundException {
        JSONArray response = new JSONArray();
        response.put(refcursorRepositoryImpl.getResponseByCode(code));
        return response;
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public JSONArray getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException {
        JSONArray response = new JSONArray();
        response.put(refcursorRepositoryImpl.getResponseByLot(login, lotNum, startDate, endDate));
        return response;
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public JSONArray getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException {
        JSONArray response = new JSONArray();
        response.put(refcursorRepositoryImpl.getResponseByDiapason(codeStart, codeFinish));
        return response;
    }

}
