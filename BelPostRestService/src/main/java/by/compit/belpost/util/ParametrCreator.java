package by.compit.belpost.util;

import org.json.JSONArray;

import java.util.ArrayList;

public interface ParametrCreator {

    String getCode(JSONArray jsonArray);

    String getLogin(JSONArray jsonArray);

    String getLotNum(JSONArray jsonArray);

    String getStartDate(JSONArray jsonArray);

    String getEndDate(JSONArray jsonArray);

    String getCodeStart(JSONArray jsonArray);

    String getCodeFinish(JSONArray jsonArray);


}
