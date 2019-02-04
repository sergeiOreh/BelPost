package by.compit.belpost.srervice;

import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;

public interface ResponseGetter {

    JSONArray getResponseByPo(String code) throws NotFoundException;

    JSONArray getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException;

    JSONArray getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException;


}
