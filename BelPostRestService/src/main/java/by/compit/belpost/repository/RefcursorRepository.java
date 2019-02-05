package by.compit.belpost.repository;

import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;

public interface RefcursorRepository {

    JSONArray getResponseByCode(String code) throws NotFoundException;

    JSONArray getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException;

    JSONArray getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException;
}
