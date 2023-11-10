package com.ceiba.papeleria.venta.adaptador.repositorio;

import com.ceiba.papeleria.infraestructura.jdbc.MapperResult;
import com.ceiba.papeleria.venta.modelo.entidad.Venta;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioDetalleVenta;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;

@Component
public class MapeoVenta implements RowMapper<Venta>, MapperResult {

    private final RepositorioDetalleVenta repositorioDetalleVenta;

    public MapeoVenta(RepositorioDetalleVenta repositorioDetalleVenta) {
        this.repositorioDetalleVenta = repositorioDetalleVenta;
    }

    @Override
    public Venta mapRow(ResultSet resultSet, int rowNum) throws SQLException {
        long id = resultSet.getLong("id");
        LocalDate fecha = resultSet.getTimestamp("fecha").toLocalDateTime().toLocalDate();
        BigDecimal total = resultSet.getBigDecimal("total");
        BigDecimal porcentajeDescuentoAplicadoVentas = resultSet.getBigDecimal("porcentaje_descuento_aplicado_venta");

        return Venta.reconstruir(id, repositorioDetalleVenta.obtenerPorVenta(id),
                fecha, total, porcentajeDescuentoAplicadoVentas);
    }
}
