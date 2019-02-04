package by.compit.belpost.controller;

import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.srervice.ResponseGetter;
import by.compit.belpost.util.ParametrCreator;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.ParseException;

@RestController
public class ClientController {

    private static final String GET_OPER_4_PO_URL = "${get.oper.po.url}";
    private static final String GET_OPER_4_LOT_URL = "${get.oper.lot.url}";
    private static final String GET_OPER_4_DIAPASON_URL = "${get.oper.diapason.url}";

    private final ResponseGetter responseGetter;
    private final ParametrCreator parametrCreator;


    @Autowired
    public ClientController(ResponseGetter responseGetter, ParametrCreator parametrCreator) {
        this.responseGetter = responseGetter;
        this.parametrCreator = parametrCreator;
    }

    @RequestMapping(value = GET_OPER_4_PO_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public String getResponses4Po(@RequestBody String request) throws NotFoundException{

        return responseGetter.getResponseByPo(parametrCreator.getCode(new JSONArray(request))).toString();
    }

    @RequestMapping(value = GET_OPER_4_LOT_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public String getResponses4Lot(@RequestBody String request) throws ParseException, NotFoundException {

        return responseGetter.getResponseByLot(parametrCreator.getLogin(new JSONArray(request)),
                parametrCreator.getLotNum(new JSONArray(request)),
                parametrCreator.getStartDate(new JSONArray(request)),
                parametrCreator.getEndDate(new JSONArray(request))).toString();
    }

    @RequestMapping(value = GET_OPER_4_DIAPASON_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public String getResponses4Diapason(@RequestBody String request) throws NotFoundException{

        return responseGetter.getResponseByDiapason(parametrCreator.getCodeStart(new JSONArray(request)),
                parametrCreator.getCodeFinish(new JSONArray(request))).toString();
    }


}
