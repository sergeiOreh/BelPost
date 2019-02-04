package by.compit.belpost.repository.impl;

import by.compit.belpost.entity.Response;
import by.compit.belpost.repository.RefcursorRepository;
import by.compit.belpost.srervice.ConnectionService;
import oracle.jdbc.OracleCallableStatement;
import oracle.jdbc.OracleTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
@Transactional
public class RefcursorRepositoryImpl implements RefcursorRepository {

    private ConnectionService connection;

    @Autowired
    public RefcursorRepositoryImpl(ConnectionService connection) {
        this.connection = connection;
    }

    @Override
    public List<Response> getResponseByCode(String code) {

        try {
            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_PO(?)}";

            OracleCallableStatement st =
                    (OracleCallableStatement) con.prepareCall(stmt);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2, code);
            System.out.println(st.execute());
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
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;

    }

    @Override
    public List<Response> getResponseByLot(String login, String lotNum, String startDate, String endDate) {
        try {
            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_LOT(?,?,?,?)}";

            OracleCallableStatement st =
                    (OracleCallableStatement) con.prepareCall(stmt);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2, login);
            st.setString(3, lotNum);
            st.setString(4, startDate);
            st.setString(5, endDate);
            System.out.println(st.execute());
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
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Response> getResponseByDiapason(String codeStart, String codeFinish) {
        try {
            Connection con = connection.getConnection();
            Response response;
            List<Response> responseList = new ArrayList<>();

            String stmt = "{? = call PKG_EXP_PORTAL.GET_OPER_4_DIAPASON(?,?)}";

            OracleCallableStatement st =
                    (OracleCallableStatement) con.prepareCall(stmt);
            st.registerOutParameter(1, OracleTypes.CURSOR);
            st.setString(2, codeStart);
            st.setString(2, codeFinish);
            System.out.println(st.execute());
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
            return responseList;
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }
        return null;
    }
}
