package by.compit.belpost.controller;

import by.compit.belpost.repository.RefcursorRepository;
import by.compit.belpost.srervice.ResponseGetter;
import by.compit.belpost.util.ParametrCreater;
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
    private final ParametrCreater parametrCreater;
    private final RefcursorRepository refcursorRepository;

    @Autowired
    public ClientReceiverController(ResponseGetter responseGetter, ParametrCreater parametrCreater, RefcursorRepository refcursorRepository) {
        this.responseGetter = responseGetter;
        this.parametrCreater = parametrCreater;
        this.refcursorRepository = refcursorRepository;
    }

//    @RequestMapping(value = GET_OPER_4_PO_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
//    public String getCityNameById(@RequestBody String request) {
//
//        return responseGetter.getResponseByCityId(parametrCreater.getId(new JSONArray(request))).toString();
//    }

    @RequestMapping(value = GET_OPER_4_PO_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public String getResponses(@RequestBody String request) {

        return responseGetter.getResponseByCode(parametrCreater.getCode(new JSONArray(request))).toString();
    }



}
