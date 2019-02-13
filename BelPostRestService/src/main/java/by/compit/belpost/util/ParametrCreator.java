package by.compit.belpost.util;

import org.json.JSONArray;

import java.util.ArrayList;

public interface ParametrCreator {

    ArrayList<String> getCode(JSONArray jsonArray);

    ArrayList<String> getLogin(JSONArray jsonArray);

    ArrayList<String> getLotNum(JSONArray jsonArray);

    ArrayList<String> getStartDate(JSONArray jsonArray);

    ArrayList<String> getEndDate(JSONArray jsonArray);

    ArrayList<String> getCodeStart(JSONArray jsonArray);

    ArrayList<String> getCodeFinish(JSONArray jsonArray);


}
