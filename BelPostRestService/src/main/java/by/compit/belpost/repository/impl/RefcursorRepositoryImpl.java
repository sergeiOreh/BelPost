package by.compit.belpost.repository.impl;

import by.compit.belpost.entity.Response;
import by.compit.belpost.exception.NotFoundException;
import by.compit.belpost.repository.RefcursorRepository;
import by.compit.belpost.srervice.ConnectionService;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.json.JSONArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Класс RefcursorRepositoryImpl предназначен для получения ответов из базы данных по созданным в ней функциям.
 */
@Repository
@Transactional
public class RefcursorRepositoryImpl implements RefcursorRepository {

    private ConnectionService connection;

    @Autowired
    public RefcursorRepositoryImpl(ConnectionService connection) {
        this.connection = connection;
    }

    /**
     * Возвращает список ответов по переданному в функцию параметру.
     *
     * @param codes - переданная в функцию коллекция
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @SuppressWarnings("Duplicates")
    @Override
    public ArrayList<Response> getResponseByCodes(ArrayList<String> codes) throws NotFoundException {

        try {
            Connection con = connection.getConnection();
            Response response;
            ArrayList<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_PO(?)}";

            for (String code : codes) {
                OracleCallableStatement st =
                        (OracleCallableStatement) con.prepareCall(stmt);
                st.registerOutParameter(1, OracleTypes.CURSOR);
                st.setString(2, code);
                st.execute();
                ResultSet rs = st.getCursor(1);
                while (rs.next()) {
                    response = new Response();
                    response.setCode(rs.getString(1));
                    response.setOtoDate(rs.getString(2));
                    response.setOperName(rs.getString(3));
                    response.setOrgCur(rs.getString(4));
                    response.setZipCodeNext(rs.getString(5));
                    responseList.add(response);
                }
                st.close();
            }
            con.close();
            if (responseList.size() == 0) throw new NotFoundException();
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Возвращает список ответов по переданному в функцию параметру.
     *
     * @param logins     - переданный в функцию параметр
     * @param lotNums    - переданный в функцию параметр
     * @param startDates - переданный в функцию параметр
     * @param endDates   - переданный в функцию параметр
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     * @throws ParseException,    если введён неверный формат даты
     */
    @SuppressWarnings("Duplicates")
    @Override
    public ArrayList<Response> getResponseByLot(ArrayList<String> logins, ArrayList<String> lotNums, ArrayList<String> startDates, ArrayList<String> endDates) throws ParseException, NotFoundException {
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

            Connection con = connection.getConnection();
            Response response;
            ArrayList<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_LOT(?,?,?,?)}";

            for (int i = 0; i < logins.size(); i++) {
                for (int i1 = 0; i1 < lotNums.size(); i1++) {
                    for (int i2 = 0; i2 < startDates.size(); i2++) {
                        for (int i3 = 0; i3 < endDates.size(); i3++) {
                            if (i == i1 & i == i2 & i == i3) {

                                java.util.Date start = formatter.parse(startDates.get(i2));
                                java.util.Date end = formatter.parse(endDates.get(i3));

                                OracleCallableStatement st =
                                        (OracleCallableStatement) con.prepareCall(stmt);
                                st.registerOutParameter(1, OracleTypes.CURSOR);
                                st.setString(2, logins.get(i));
                                st.setString(3, lotNums.get(i1));
                                st.setDate(4, new Date(start.getTime()));
                                st.setDate(5, new Date(end.getTime()));
                                st.execute();
                                ResultSet rs = st.getCursor(1);
                                while (rs.next()) {
                                    response = new Response();
                                    response.setCode(rs.getString(1));
                                    response.setOtoDate(rs.getString(2));
                                    response.setOperName(rs.getString(3));
                                    response.setOrgCur(rs.getString(4));
                                    response.setZipCodeNext(rs.getString(5));
                                    responseList.add(response);
                                }
                                st.close();
                            }
                        }
                    }
                }
            }
            con.close();
            if (responseList.size() == 0) throw new NotFoundException();
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    /**
     * Возвращает список ответов по переданному в функцию параметру.
     *
     * @param codesStart  - переданный в функцию параметр
     * @param codesFinish - переданный в функцию параметр
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @SuppressWarnings("Duplicates")
    @Override
    public ArrayList<Response> getResponseByDiapasons(ArrayList<String> codesStart, ArrayList<String> codesFinish) throws NotFoundException {
        try {
            Connection con = connection.getConnection();
            Response response;
            ArrayList<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_DIAPASON(?,?)}";

            for (int x = 0; x < codesStart.size(); x++) {
                for (int y = 0; y < codesFinish.size(); y++) {
                    if (x == y) {
                        OracleCallableStatement st =
                                (OracleCallableStatement) con.prepareCall(stmt);
                        st.registerOutParameter(1, OracleTypes.CURSOR);
                        st.setString(2, codesStart.get(x));
                        st.setString(3, codesFinish.get(y));
                        st.execute();
                        ResultSet rs = st.getCursor(1);
                        while (rs.next()) {
                            response = new Response();
                            response.setCode(rs.getString(1));
                            response.setOtoDate(rs.getString(2));
                            response.setOperName(rs.getString(3));
                            response.setOrgCur(rs.getString(4));
                            response.setZipCodeNext(rs.getString(5));
                            responseList.add(response);
                        }
                        st.close();
                    }
                }
            }
            con.close();
            if (responseList.size() == 0) throw new NotFoundException();
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
