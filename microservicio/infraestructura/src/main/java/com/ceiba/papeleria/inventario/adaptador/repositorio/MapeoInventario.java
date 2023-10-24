package com.ceiba.papeleria.inventario.adaptador.repositorio;

import com.ceiba.papeleria.infraestructura.jdbc.MapperResult;
import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;
import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class MapeoInventario implements RowMapper<Inventario>, MapperResult {
    @Override
    public Inventario mapRow(ResultSet resultSet, int rowNum) throws SQLException {

        Long id = resultSet.getLong("id");
        Integer cantidadDisponible = resultSet.getInt("cantidad_disponible");
        LocalDate fechaEntrada = resultSet.getDate("fecha_entrada").toLocalDate();

        return Inventario.reconstruir(id, cantidadDisponible, fechaEntrada);

    }
}
