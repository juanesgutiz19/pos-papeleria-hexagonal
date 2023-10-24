package com.ceiba.papeleria.inventario.adaptador.repositorio;


import com.ceiba.papeleria.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.papeleria.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.papeleria.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.papeleria.inventario.modelo.entidad.Inventario;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioInventarioMysql implements RepositorioInventario {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    private final MapeoInventario mapeoInventario;

    @SqlStatement(namespace = "inventario", value = "obtenerporarticulo")
    private static String sqlObtenerPorArticulo;

    @SqlStatement(namespace = "inventario", value = "actualizarcantidaddisponible")
    private static String sqlActualizarCantidadDisponible;

    public RepositorioInventarioMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate, MapeoInventario mapeoInventario) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
        this.mapeoInventario = mapeoInventario;
    }

    @Override
    public Inventario obtenerPorArticulo(String idArticulo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id_articulo", idArticulo);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() -> this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate()
                .queryForObject(sqlObtenerPorArticulo, paramSource, mapeoInventario));
    }

    @Override
    public void actualizarCantidadDisponibleArticulo(Inventario inventario) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", inventario.getId());
        paramSource.addValue("cantidad_disponible", inventario.getCantidadDisponible());
        this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().update(sqlActualizarCantidadDisponible, paramSource);

    }
}
