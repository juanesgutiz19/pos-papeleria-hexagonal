package com.ceiba.papeleria.producto.adaptador.repositorio;

import com.ceiba.papeleria.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.papeleria.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.papeleria.infraestructura.jdbc.sqlstatement.SqlStatement;
import com.ceiba.papeleria.producto.entidad.Producto;
import com.ceiba.papeleria.producto.puerto.RepositorioProducto;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioProductoMysql implements RepositorioProducto {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "producto", value = "obtenerporid")
    private static String sqlObtenerPorId;

    public RepositorioProductoMysql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Producto obtener(Long id) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("id", id);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorId,
                        paramSource, new MapeoProducto()));
    }

}
