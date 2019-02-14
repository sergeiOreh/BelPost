package by.compit.belpost.srervice.impl;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.repository.impl.RefcursorRepositoryImpl;
import by.compit.belpost.srervice.ResponseGetter;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.ArrayList;
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
    public ArrayList<Response> getResponseByPo(ArrayList<String> codes) throws NotFoundException {
        return refcursorRepositoryImpl.getResponseByCodes(codes);
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public ArrayList<Response> getResponseByLot(ArrayList<String> logins, ArrayList<String> lotNums, ArrayList<String> startDates, ArrayList<String> endDates) throws ParseException, NotFoundException {
        return refcursorRepositoryImpl.getResponseByLot(logins, lotNums, startDates, endDates);
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public ArrayList<Response> getResponseByDiapason(ArrayList<String> codesStart, ArrayList<String> codesFinish) throws NotFoundException {
        return refcursorRepositoryImpl.getResponseByDiapasons(codesStart, codesFinish);
    }

}
