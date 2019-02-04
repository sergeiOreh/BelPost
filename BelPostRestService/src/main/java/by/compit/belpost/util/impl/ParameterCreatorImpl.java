package by.compit.belpost.util.impl;

import by.compit.belpost.util.ParametrCreator;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ParameterCreatorImpl implements ParametrCreator {

    @Value("${code.parameter}")
    private String CODE_PARAMETER;
    @Value("${login.parameter}")
    private String LOGIN_PARAMETER;
    @Value("${lot.num.parameter}")
    private String LOT_NUM_PARAMETER;
    @Value("${start.date.parameter}")
    private String START_DATE_PARAMETER;
    @Value("${end.date.parameter}")
    private String END_DATE_PARAMETER;
    @Value("${code.start.parameter}")
    private String CODE_START_PARAMETER;
    @Value("${code.finish.parameter}")
    private String CODE_FINISH_PARAMETER;

    @Override
    public String getCode(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(CODE_PARAMETER);
        }
        return null;
    }

    @Override
    public String getLogin(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(LOGIN_PARAMETER);
        }
        return null;
    }

    @Override
    public String getLotNum(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(LOT_NUM_PARAMETER);
        }
        return null;
    }

    @Override
    public String getStartDate(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(START_DATE_PARAMETER);
        }
        return null;
    }

    @Override
    public String getEndDate(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(END_DATE_PARAMETER);
        }
        return null;
    }

    @Override
    public String getCodeStart(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(CODE_START_PARAMETER);
        }
        return null;
    }

    @Override
    public String getCodeFinish(JSONArray jsonArray) {
        for (int i = 0; i < jsonArray.length(); i++) {
            return jsonArray.getJSONObject(i).getString(CODE_FINISH_PARAMETER);
        }
        return null;
    }


}
