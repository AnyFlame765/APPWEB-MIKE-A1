package server;

import utils.MySQLConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class DaoRFC {
    public boolean saveRFC(BeanRFC rfc) {
        boolean result = false;
        try (
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement("insert into rfc (rfc,name,apellido1, apellido2, curp, año, mes, dia)values (?,?,?,?,?,?,?,?); ")
        )
        {
            pstm.setString(1, rfc.getRfc());
            pstm.setString(2, rfc.getName());
            pstm.setString(3,rfc.getApellido1());
            pstm.setString(4,rfc.getApellido2());
            pstm.setString(5, rfc.getCurp());
            pstm.setString(6, rfc.getAnio());
            pstm.setString(7,rfc.getMes());
            pstm.setString(8, rfc.getDia());
            result = pstm.executeUpdate() ==1;

        }catch (Exception e){
            e.printStackTrace();
        }
        return  result;

    }

    public List<BeanRFC> listPerson(BeanRFC curp){
        List<BeanRFC>  listPerson = new ArrayList<>();

        try {
            Connection connection = MySQLConnection.getConnection();
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("select * from games where curp=?");
            while (rs.next()){
                BeanRFC rfc = new BeanRFC();
                rfc.setId(rs.getInt("id"));
                rfc.setName(rs.getString("name"));
                rfc.setApellido1(rs.getString("apellido1"));
                rfc.setApellido2(rs.getString("apellido2"));
                rfc.setCurp(rs.getString("curp"));
                rfc.setAnio(rs.getString("anio"));
                rfc.setMes(rs.getString("mes"));
                rfc.setDia(rs.getString("dia"));
                listPerson.add(rfc);
            };

            rs.close();
            connection.close();
            statement.close();

        } catch(Exception e) {
            e.printStackTrace();
        }

        return listPerson;
    }

    public boolean updatePerson(BeanRFC rfc) {
        boolean result = false;
        try (
                Connection con = MySQLConnection.getConnection();
                PreparedStatement pstm = con.prepareStatement
                        ("UPDATE  games set name =?,genere=?, year=?, rating=? where id_game=?; ")

        )
        {
            pstm.setString(1, rfc.getRfc());
            pstm.setString(2, rfc.getName());
            pstm.setString(3,rfc.getApellido1());
            pstm.setString(4,rfc.getApellido2());
            pstm.setString(5, rfc.getCurp());
            pstm.setString(6, rfc.getAnio());
            pstm.setString(7,rfc.getMes());
            pstm.setString(8, rfc.getDia());

            result = pstm.executeUpdate() ==1;


        }catch (Exception e){
            e.printStackTrace();

        }
        return  result;

    }
}
