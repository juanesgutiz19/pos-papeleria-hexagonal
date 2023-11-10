package com.ceiba.papeleria.venta.adaptador.repositorio;

import com.ceiba.papeleria.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.papeleria.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.papeleria.venta.modelo.entidad.Venta;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioDetalleVenta;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioVenta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioVentaMysql implements RepositorioVenta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoVenta mapeoVenta;

    private final RepositorioDetalleVenta repositorioDetalleVenta;

    @SqlStatement(namespace = "venta", value = "crear")
    private static String sqlCrear;

    public RepositorioVentaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoVenta mapeoVenta, RepositorioDetalleVenta repositorioDetalleVenta) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoVenta = mapeoVenta;
        this.repositorioDetalleVenta = repositorioDetalleVenta;
    }

    @Override
    public Long guardar(Venta venta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("fecha", venta.getFecha());
        paramSource.addValue("total", venta.getTotal());
        paramSource.addValue("porcentaje_descuento_aplicado_venta", venta.getPorcentajeDescuentoAplicadoVentas());
        Long idVentaGuardada = this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
        repositorioDetalleVenta.guardarPorVenta(venta, idVentaGuardada);
        return idVentaGuardada;
    }
}
