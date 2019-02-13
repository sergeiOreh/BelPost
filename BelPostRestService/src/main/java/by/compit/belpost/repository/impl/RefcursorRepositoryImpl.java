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
     * @param code - переданный в функцию параметр
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @SuppressWarnings("Duplicates")
    @Override
    public List<Response> getResponseByCode(String code) throws NotFoundException {

        try {
            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_PO(?)}";

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
     * @param login - переданный в функцию параметр
     * @param lotNum - переданный в функцию параметр
     * @param startDate - переданный в функцию параметр
     * @param endDate - переданный в функцию параметр
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     * @throws ParseException, если введён неверный формат даты
     */
    @SuppressWarnings("Duplicates")
    @Override
    public List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) throws ParseException, NotFoundException {
        try {

            SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            java.util.Date start = formatter.parse(startDate);
            java.util.Date end = formatter.parse(endDate);

            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_LOT(?,?,?,?)}";

            OracleCallableStatement st =
                    (OracleCallableStatement) con.prepareCall(stmt);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2, login);
            st.setString(3, lotNum);
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
     * @param codeStart - переданный в функцию параметр
     * @param codeFinish - переданный в функцию параметр
     * @return список ответов
     * @throws NotFoundException, если нет ответа по данным параметрам
     */
    @SuppressWarnings("Duplicates")
    @Override
    public List<Response> getResponseByDiapason(String codeStart, String codeFinish) throws NotFoundException {
        try {
            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_DIAPASON(?,?)}";

            OracleCallableStatement st =
                    (OracleCallableStatement) con.prepareCall(stmt);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2, codeStart);
            st.setString(3, codeFinish);
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
