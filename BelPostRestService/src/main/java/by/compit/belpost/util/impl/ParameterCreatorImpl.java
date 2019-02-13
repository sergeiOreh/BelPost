package by.compit.belpost.util.impl;

import by.compit.belpost.util.ParametrCreator;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Класс ParameterCreatorImpl содержит реализацию методов по парсингу параметров из формата {@link JSONArray}.
 */
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

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getCode(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(CODE_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getLogin(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(LOGIN_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getLotNum(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(LOT_NUM_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getStartDate(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(START_DATE_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getEndDate(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(END_DATE_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getCodeStart(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(CODE_START_PARAMETER));
        }
        return parameters;
    }

    /**
     * @return параметр типа {@link String}
     */
    @Override
    public ArrayList<String> getCodeFinish(JSONArray jsonArray) {
        ArrayList<String> parameters = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            parameters.add(jsonArray.getJSONObject(i).getString(CODE_FINISH_PARAMETER));
        }
        return parameters;
    }
}
