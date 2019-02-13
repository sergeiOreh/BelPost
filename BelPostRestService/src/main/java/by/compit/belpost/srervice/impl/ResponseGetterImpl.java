package by.compit.belpost.srervice.impl;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.repository.impl.RefcursorRepositoryImpl;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.List;

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
    public List<Response> getResponseByPo(String code) throws NotFoundException {
        return refcursorRepositoryImpl.getResponseByCode(code);
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException {
        return refcursorRepositoryImpl.getResponseByLot(login, lotNum, startDate, endDate);
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public List<Response> getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException {
        return refcursorRepositoryImpl.getResponseByDiapason(codeStart, codeFinish);
    }

}
