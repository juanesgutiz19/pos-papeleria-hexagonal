package com.ceiba.papeleria.articulo.adaptador.repositorio;

import com.ceiba.papeleria.articulo.modelo.entidad.Articulo;
import com.ceiba.papeleria.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.papeleria.infraestructura.jdbc.CustomNamedParameterJdbcTemplate;
import com.ceiba.papeleria.infraestructura.jdbc.EjecucionBaseDeDatos;
import com.ceiba.papeleria.infraestructura.jdbc.sqlstatement.SqlStatement;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.stereotype.Repository;

@Repository
public class RepositorioArticuloMySql implements RepositorioArticulo {

    private final CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate;

    @SqlStatement(namespace = "articulo", value = "obtenerporcodigo")
    private static String sqlObtenerPorCodigo;

    public RepositorioArticuloMySql(CustomNamedParameterJdbcTemplate customNamedParameterJdbcTemplate) {
        this.customNamedParameterJdbcTemplate = customNamedParameterJdbcTemplate;
    }

    @Override
    public Articulo obtener(String codigo) {
        MapSqlParameterSource paramSource = new MapSqlParameterSource();
        paramSource.addValue("codigo", codigo);
        return EjecucionBaseDeDatos.obtenerUnObjetoONull(() ->
                this.customNamedParameterJdbcTemplate.getNamedParameterJdbcTemplate().queryForObject(sqlObtenerPorCodigo,
                        paramSource, new MapeoArticulo()));
    }
}
