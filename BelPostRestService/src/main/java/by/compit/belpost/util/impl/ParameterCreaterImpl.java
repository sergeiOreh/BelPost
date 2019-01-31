package by.compit.belpost.util.impl;

import by.compit.belpost.util.ParametrCreater;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class ParameterCreaterImpl implements ParametrCreater {

    @Value("${ID.parameter}")
    private String ID_PARAMETER;
    @Value("${code.parameter}")
    private String CODE_PARAMETER;

    @Override
    public Integer getId(JSONArray jsonArray) {

        Integer id = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            id = jsonArray.getJSONObject(i).getInt(ID_PARAMETER);
        }
        return id;

    }

    @Override
    public String getCode(JSONArray jsonArray) {
        String code = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            code = jsonArray.getJSONObject(i).getString(CODE_PARAMETER);
        }
        System.out.println("code = " + code);
        return code;
    }


}
