package com.example.examen.Daos;

import com.example.examen.Beans.Empleado;
import com.example.examen.Beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class ReporteDao extends BaseDao{

    public int obtenernumeroSinjefe(){
        int cantidadSinjefe =0;
        String sql="select count(*) from empleado where idjefe is null;";
        try(Connection conn=this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            try(ResultSet rs= pstmt.executeQuery()){
                if(rs.next()){
                    cantidadSinjefe = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cantidadSinjefe;
    }

    public ArrayList<Empleado> listasinjefe(){
        String sql="select nombre, apellido, dni, salario, fechaContrato, edad from empleado where idjefe is null";
        ArrayList<Empleado> empleadosin= new ArrayList<>();
        try(Connection conn= this.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);){
            while(rs.next()){
                Empleado empleado = new Empleado();
                empleado.setNombre(rs.getString(1));
                empleado.setApellido(rs.getString(2));
                empleado.setDni(rs.getString(3));
                empleado.setSalario(rs.getBigDecimal(4));
                empleado.setFechaContrato(rs.getString(5));
                empleado.setEdad(rs.getInt(6));
                empleadosin.add(empleado);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return empleadosin;
    }

    public int obtenernumero3d(){
        int numero3d =0;
        String sql="select count(car.3d) from cartelera car \n" +
                "inner join pelicula pe on car.idpelicula = pe.idpelicula;";
        try(Connection conn=this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            try(ResultSet rs= pstmt.executeQuery()){
                if(rs.next()){
                    numero3d = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return numero3d;
    }

    public int obtenerempleadosSalario(){
        int mayor =0;
        String sql="select count(*) from empleado where salario > 9700;";
        try(Connection conn=this.getConnection();
            PreparedStatement pstmt= conn.prepareStatement(sql)){
            try(ResultSet rs= pstmt.executeQuery()){
                if(rs.next()){
                    mayor = rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return mayor;
    }


    public String obtenerCadena(){
        String cadena = null;
        String sql = "select ca.nombre_comercial from cartelera car inner join cine ci on car.idcine = ci.idcine inner join cadena ca on ca.idcadena = ci.idcadena group by ca.nombre_comercial limit 1;\n";
        try(Connection conn = this.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)){
            try(ResultSet rs = pstmt.executeQuery()){
                if(rs.next()){
                    cadena = rs.getString(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cadena;
    }







}
