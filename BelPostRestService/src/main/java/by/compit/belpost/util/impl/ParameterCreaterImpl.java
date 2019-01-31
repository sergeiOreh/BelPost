package by.compit.belpost.util.impl;

import by.compit.belpost.util.IDProcessor;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class IDProcessorImpl implements IDProcessor {

    @Value("${ID.parameter}")
    private String ID_PARAMETER;

    @Override
    public Integer getId(JSONArray jsonArray) {

        Integer id = null;

        for (int i = 0; i < jsonArray.length(); i++) {
            id = jsonArray.getJSONObject(i).getInt(ID_PARAMETER);
        }
        return id;

    }
}
