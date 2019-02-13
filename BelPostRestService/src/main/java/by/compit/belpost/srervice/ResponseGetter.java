package by.compit.belpost.srervice;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;

import java.text.ParseException;
import java.util.List;

public interface ResponseGetter {

    List<Response> getResponseByPo(String code) throws NotFoundException;

    List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException;

    List<Response> getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException;


}
