package com.ceiba.papeleria.venta.adaptador.repositorio;

import com.ceiba.papeleria.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.papeleria.infraestructura.jdbc.MapperResult;
import com.ceiba.papeleria.venta.modelo.entidad.DetalleVenta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;

@Component
public class MapeoDetalleVenta implements RowMapper<DetalleVenta>, MapperResult {

    private final RepositorioArticulo repositorioArticulo;

    public MapeoDetalleVenta(RepositorioArticulo repositorioArticulo) {
        this.repositorioArticulo = repositorioArticulo;
    }

    @Override
    public DetalleVenta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        String idArticulo = resultSet.getString("id_articulo");
        int cantidad = resultSet.getInt("cantidad");
        BigDecimal subtotal = resultSet.getBigDecimal("subtotal");
        BigDecimal porcentajeDescuentoAplicadoDetalle = resultSet.getBigDecimal("porcentaje_descuento_aplicado_detalle");

        return DetalleVenta.reconstruir(id, repositorioArticulo.obtener(idArticulo), cantidad, subtotal, porcentajeDescuentoAplicadoDetalle);
    }
}
