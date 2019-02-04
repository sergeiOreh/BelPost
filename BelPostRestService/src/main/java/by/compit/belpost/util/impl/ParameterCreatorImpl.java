package by.compit.belpost.util.impl;

import by.compit.belpost.util.ParametrCreater;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class ParameterCreaterImpl implements ParametrCreater {

    @Value("${code.parameter}")
    private String CODE_PARAMETER;

    @Override
    public ArrayList<String> getCodes(JSONArray jsonArray) {
        ArrayList<String> codes = new ArrayList<>();
        for (int i = 0; i < jsonArray.length(); i++) {
            codes.add(jsonArray.getJSONObject(i).getString(CODE_PARAMETER));
        }
        return codes;
    }


}
