package by.compit.belpost.srervice;

import org.json.JSONArray;

import java.util.ArrayList;

public interface ResponseGetter {

    JSONArray getResponseByPo(String code);

    JSONArray getResponseByLot(String login, String lotNum, String startDate, String endDate);

    JSONArray getResponseByDiapason(String codeStart, String codeFinish);


}
