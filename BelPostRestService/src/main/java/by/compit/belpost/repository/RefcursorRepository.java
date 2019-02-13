package by.compit.belpost.repository;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.List;

public interface RefcursorRepository {

    List<Response> getResponseByCode(String code) throws NotFoundException;

    List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException;

    List<Response> getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException;
}
