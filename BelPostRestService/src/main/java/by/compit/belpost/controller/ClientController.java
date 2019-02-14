package by.compit.belpost.controller;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.srervice.ResponseGetter;
import by.compit.belpost.util.ParametrCreator;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;

/**
 * Класс ClientController предназначен для взаимодействия с пользователем через url
 * и получения ответа
 */
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

    /**
     * @return ответ по переданным в теле запроса параметрам
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @RequestMapping(value = GET_OPER_4_PO_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public ArrayList<Response> getResponses4Po(@RequestBody String request) throws NotFoundException{

        return responseGetter.getResponseByPo(parametrCreator.getCode(new JSONArray(request)));
    }

    /**
     * @return ответ по переданным в теле запроса параметрам
     * @throws NotFoundException, если нет ответа по данным параметрам
     * @throws ParseException, если введён неверный формат даты
     */
    @RequestMapping(value = GET_OPER_4_LOT_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public ArrayList<Response> getResponses4Lot(@RequestBody String request) throws ParseException, NotFoundException {

        return responseGetter.getResponseByLot(parametrCreator.getLogin(new JSONArray(request)),
                parametrCreator.getLotNum(new JSONArray(request)),
                parametrCreator.getStartDate(new JSONArray(request)),
                parametrCreator.getEndDate(new JSONArray(request)));
    }

    /**
     * @return ответ по переданным в теле запроса параметрам
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @RequestMapping(value = GET_OPER_4_DIAPASON_URL, method = RequestMethod.POST, consumes = "application/json", produces = "application/json; charset=utf-8")
    public ArrayList<Response> getResponses4Diapason(@RequestBody String request) throws NotFoundException{

        return responseGetter.getResponseByDiapason(parametrCreator.getCodeStart(new JSONArray(request)),
                parametrCreator.getCodeFinish(new JSONArray(request)));
    }

}
