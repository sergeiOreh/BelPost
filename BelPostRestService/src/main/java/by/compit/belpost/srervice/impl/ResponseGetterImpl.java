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
    public JSONArray getResponseByPo(ArrayList<String> codes) throws NotFoundException {
        JSONArray response = new JSONArray();
        for (String code : codes) {
            response.put(refcursorRepositoryImpl.getResponseByCode(code));
        }
        return response;
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public JSONArray getResponseByLot(ArrayList<String> logins, ArrayList<String> lotNums, ArrayList<String> startDates, ArrayList<String> endDates) throws ParseException, NotFoundException {
        JSONArray response = new JSONArray();
        for (String login : logins) {
            for (String lotNum : lotNums) {
                for (String startDate : startDates) {
                    for (String endDate : endDates) {
                        refcursorRepositoryImpl.getResponseByLot(login, lotNum, startDate, endDate);
                    }
                }
            }
        }
        return response;
    }

    /**
     * @return ответ в формате {@link JSONArray}
     */
    @Override
    public JSONArray getResponseByDiapason(ArrayList<String> codesStart, ArrayList<String> codesFinish) throws NotFoundException {
        JSONArray response = new JSONArray();
        for (String codeStart : codesStart) {
            for (String codeFinish : codesFinish) {
                response.put(refcursorRepositoryImpl.getResponseByDiapason(codeStart, codeFinish));
            }
        }
        return response;
    }

}
