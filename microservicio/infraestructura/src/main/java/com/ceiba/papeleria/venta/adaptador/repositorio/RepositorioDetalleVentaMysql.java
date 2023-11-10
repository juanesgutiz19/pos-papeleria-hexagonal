package com.ceiba.papeleria.venta.adaptador.repositorio;

import com.ceiba.papeleria.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.papeleria.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.papeleria.venta.modelo.entidad.DetalleVenta;
import com.ceiba.papeleria.venta.modelo.entidad.Venta;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioDetalleVenta;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RepositorioDetalleVentaMysql implements RepositorioDetalleVenta {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;
    private final MapeoDetalleVenta mapeoDetalleVenta;

    @SqlStatement(namespace = "detalleventa", value = "obtenerporventa")
    private static String sqlObtenerPorVenta;

    @SqlStatement(namespace = "detalleventa", value = "crear")
    private static String sqlCrear;

    public RepositorioDetalleVentaMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoDetalleVenta mapeoDetalleVenta) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoDetalleVenta = mapeoDetalleVenta;
    }

    @Override
    public void guardarPorVenta(Venta venta, Long idVenta) {
        venta.getDetallesVenta().stream().forEach(detalleVenta -> this.guardar(detalleVenta, idVenta));
    }

    @Override
    public List<DetalleVenta> obtenerPorVenta(Long idVenta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_venta", idVenta);
        return this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .query(sqlObtenerPorVenta, paramSource, mapeoDetalleVenta);
    }

    public void guardar(DetalleVenta detalleVenta, Long idVenta) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_venta", idVenta);
        paramSource.addValue("id_articulo", detalleVenta.getArticulo().getCodigo());
        paramSource.addValue("cantidad", detalleVenta.getCantidad());
        paramSource.addValue("subtotal", detalleVenta.getSubtotal());
        paramSource.addValue("porcentaje_descuento_aplicado_detalle", detalleVenta.getPorcentajeDescuentoAplicadoDetalle());
        this.customNamedParameterJdbcTemplate.crear(paramSource, sqlCrear);
    }
}
