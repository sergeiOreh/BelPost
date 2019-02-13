package by.compit.belpost.repository;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface RefcursorRepository {

    ArrayList<Response> getResponseByCode(String code) throws NotFoundException;

    ArrayList<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException;

    ArrayList<Response> getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException;
}
