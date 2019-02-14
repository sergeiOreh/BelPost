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
        for (int i = 0; i < logins.size(); i++) {
            for (int i1 = 0; i1 < lotNums.size(); i1++) {
                for (int i2 = 0; i2 < startDates.size(); i2++) {
                    for (int i3 = 0; i3 < endDates.size(); i3++) {
                        if (i == i1 & i == i2 & i == i3) {
                            refcursorRepositoryImpl.getResponseByLot(logins.get(i), lotNums.get(i1), startDates.get(i2), endDates.get(i3));
                        }
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
        for (int x = 0; x < codesStart.size(); x++) {
            for (int y = 0; y < codesFinish.size(); y++) {
                if (x == y) {
                    response.put(refcursorRepositoryImpl.getResponseByDiapason(codesStart.get(x), codesFinish.get(y)));
                }
            }
        }
        return response;
    }

}
