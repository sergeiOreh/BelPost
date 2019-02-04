package by.compit.belpost.repository;

import by.compit.belpost.entity.Response;

import java.util.List;

public interface RefcursorRepository {

    List<Response> getResponseByCode(String code);

    List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate);

    List<Response> getResponseByDiapason(String codeStart, String codeFinish);
}
