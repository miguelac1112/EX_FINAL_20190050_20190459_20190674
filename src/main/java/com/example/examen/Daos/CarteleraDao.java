package com.example.examen.Daos;

import com.example.examen.Beans.Cartelera;
import com.example.examen.Beans.Cine;
import com.example.examen.Beans.Pelicula;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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




}
