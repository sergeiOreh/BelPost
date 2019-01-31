package by.compit.belpost.controller;

import by.compit.belpost.srervice.ResponseGetter;
import by.compit.belpost.util.IDProcessor;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ClientReceiverController {

    private static final String GET_OPER_4_PO_URL = "${get.oper.po.url}";
    private static final String GET_OPER_4_LOT_URL = "${get.oper.lot.url}";
    private static final String GET_OPER_4_DIAPASON_URL = "${get.oper.diapason.url}";

    private final ResponseGetter responseGetter;
    private final IDProcessor idProcessor;

    @Autowired
    public ClientReceiverController(ResponseGetter responseGetter, IDProcessor idProcessor) {
        this.responseGetter = responseGetter;
        this.idProcessor = idProcessor;
    }

    @RequestMapping(value = GET_OPER_4_PO_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public String getCityNameById(@RequestBody String request) {

        return responseGetter.getResponseByCityId(idProcessor.getId(new JSONArray(request))).toString();
    }



}
