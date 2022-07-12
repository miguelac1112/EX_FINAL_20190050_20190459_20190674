package com.example.examen.Daos;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Cine;
import com.example.examen.Beans.Empleado;
import com.example.examen.Beans.Pelicula;

import java.sql.*;
import java.util.ArrayList;

public class CarteleraDao extends BaseDao {

    public ArrayList<Cartelera> listar(String dni){
        ArrayList<Cartelera> carteleras = new ArrayList<>();
        String sql= "SELECT car.idCartelera,pel.*,cin.*,car.3d,car.doblada,car.subtitulada,car.horario FROM empleado em inner join cine cin on em.idcine = cin.idcine \n" +
                "INNER JOIN cartelera car ON car.idcine = cin.idcine INNER JOIN pelicula pel ON pel.idpelicula = car.idpelicula where em.dni= ?";
        try (Connection connection = this.getConnection();
             PreparedStatement pstmt = connection.prepareStatement(sql);) {

            pstmt.setString(1, dni);

            try (ResultSet rs = pstmt.executeQuery();) {

                while (rs.next()) {
                    Cartelera cartelera = new Cartelera();
                    Pelicula pelicula =  new Pelicula();
                    Cine cine = new Cine();
                    cartelera.setIdCartelera(rs.getInt(1));
                    pelicula.setIdPelicula(rs.getInt(2));
                    pelicula.setNombre(rs.getString(3));
                    cine.setIdCine(rs.getInt(4));
                    cine.setNombre(rs.getString(5));
                    cartelera.setPelicula(pelicula);
                    cartelera.setCine(cine);
                    cartelera.setTresD(rs.getInt(7));
                    cartelera.setDoblada(rs.getInt(8));
                    cartelera.setSubtitulada(rs.getInt(9));
                    cartelera.setHorario(rs.getString(10));
                    carteleras.add(cartelera);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return carteleras;

    }

    public ArrayList<Pelicula> listaPelicula(){
        String sql="select nombre from pelicula";
        ArrayList<Pelicula> peliculas= new ArrayList<>();
        try(Connection conn= this.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);){
            while(rs.next()){
                Pelicula pelicula = new Pelicula();
                pelicula.setNombre(rs.getString(1));
                peliculas.add(pelicula);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return peliculas;
    }

    public ArrayList<Cine> listaCines(){
        String sql="select nombre from cine";
        ArrayList<Cine> cines= new ArrayList<>();
        try(Connection conn= this.getConnection();
            Statement stmt= conn.createStatement();
            ResultSet rs= stmt.executeQuery(sql);){
            while(rs.next()){
                Cine cine = new Cine();
                cine.setNombre(rs.getString(1));
                cines.add(cine);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return cines;
    }


    public void anadirCartelera(int idpelicula, int idcine, int tresD,int doblada, int subtitulada, String horario) {

        String sql = "insert into cartelera (idpelicula, idcine, 3d, doblada, subtitulada,horario) values (?,?,?,?,?,?);";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt= connection.prepareStatement(sql)){
            pstmt.setInt(1,idpelicula);
            pstmt.setInt(2,idcine);
            pstmt.setInt(3,tresD);
            pstmt.setInt(4,doblada);
            pstmt.setInt(5,subtitulada);
            pstmt.setString(6,horario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void actualizarCartelera(int idpelicula, int idcine, int tresD,int doblada, int subtitulada, String horario) {

        String sql = "update cartelera set idPelicula = ?, idCine= ?, 3d= ?, doblada=?, subtitulada= ?, horario= ? where idCartelera= ?;";

        try (Connection connection = this.getConnection();
             PreparedStatement pstmt= connection.prepareStatement(sql)){
            pstmt.setInt(1,idpelicula);
            pstmt.setInt(2,idcine);
            pstmt.setInt(3,tresD);
            pstmt.setInt(4,doblada);
            pstmt.setInt(5,subtitulada);
            pstmt.setString(6,horario);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public void eliminarCartelera(int idCartelera){
        String sql="delete from cartelera where idCartelera=?;";
        try(Connection conn=this.getConnection();
            PreparedStatement ptmt= conn.prepareStatement(sql);){
            ptmt.setInt(1, idCartelera);
            ptmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }



}
