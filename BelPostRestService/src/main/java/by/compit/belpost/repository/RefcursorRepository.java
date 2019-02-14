package by.compit.belpost.repository;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import org.json.JSONArray;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public interface RefcursorRepository {

    ArrayList<Response> getResponseByCodes(ArrayList<String> codes) throws NotFoundException;

    ArrayList<Response> getResponseByLot(ArrayList<String> logins, ArrayList<String> lotNums, ArrayList<String> startDates, ArrayList<String> endDates) throws ParseException, NotFoundException;

    ArrayList<Response> getResponseByDiapasons(ArrayList<String> codesStart, ArrayList<String> codesFinish) throws NotFoundException;
}
