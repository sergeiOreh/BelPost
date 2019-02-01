package by.compit.belpost.srervice;

import org.json.JSONArray;

import java.util.ArrayList;

public interface ResponseGetter {

    JSONArray getResponseByCodes(ArrayList<String> code);


}
