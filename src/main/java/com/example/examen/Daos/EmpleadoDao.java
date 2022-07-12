package com.example.examen.Daos;

import com.example.examen.Beans.Cine;
import com.example.examen.Beans.Empleado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDao extends com.example.demo1.Daos.BaseDao {
    public Empleado buscarEmpleado (String dni) {
        Empleado empleado = null;
        String sql = "select * from empleado where dni=?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, dni);

            try (ResultSet rs = pstmt.executeQuery();) {

                if (rs.next()) {
                    empleado = new Empleado();
                    empleado.setIdEmpleado(rs.getInt(1));
                    empleado.setNombre(rs.getString(2));
                    empleado.setApellido(rs.getString(3));
                    empleado.setDni(rs.getString(4));
                    empleado.setSalario(rs.getBigDecimal(5));
                    empleado.setFechaContrato(rs.getString(6));
                    empleado.setNombreUsuario(rs.getString(7));
                    empleado.setEdad(rs.getInt(8));
                    empleado.setActivo(rs.getBoolean(9));
                    Cine cine = new Cine();
                    cine.setIdCine(rs.getInt(10));
                    empleado.setCine(cine);

                    Empleado jefe = new Empleado();
                    jefe.setIdEmpleado(rs.getInt(11));
                    empleado.setJefe(jefe);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return  empleado;
    }


    public int obtenerpasword(String dni){
        int contras =0;
        String sql="select (dni - salario) from empleado where dni=?";
        try(Connection conn=this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            pstmt.setString(1, dni);
            try(ResultSet rs= pstmt.executeQuery()){
                if(rs.next()){
                    contras = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return contras;
    }
}
