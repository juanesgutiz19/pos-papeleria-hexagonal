package com.ceiba.papeleria.articulo.adaptador.dao;

import com.ceiba.papeleria.articulo.modelo.dto.ArticuloDTO;
import com.ceiba.papeleria.factura.modelo.entidad.EstadoFactura;
import com.ceiba.papeleria.infraestructura.jdbc.MapperResult;

import org.springframework.stereotype.Component;
import org.springframework.jdbc.core.RowMapper;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoArticulo implements RowMapper<ArticuloDTO>, MapperResult {

    @Override
    public ArticuloDTO mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        String codigo = resultSet.getString("codigo");
        String nombre = resultSet.getString("nombre");
        BigDecimal precioCompra = resultSet.getBigDecimal("precio_compra");
        BigDecimal precioVenta = resultSet.getBigDecimal("precio_venta");
        return new ArticuloDTO(codigo, nombre, precioCompra, precioVenta);
    }

}
