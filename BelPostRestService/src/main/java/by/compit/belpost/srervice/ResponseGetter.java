package by.compit.belpost.srervice;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface ResponseGetter {

    JSONArray getResponseByPo(ArrayList<String> codes) throws NotFoundException;

    JSONArray getResponseByLot(ArrayList<String> logins, ArrayList<String> lotNums, ArrayList<String> startDates, ArrayList<String> endDates) throws ParseException, NotFoundException;

    JSONArray getResponseByDiapason(ArrayList<String> codesStart, ArrayList<String> codesFinish) throws NotFoundException;


}
