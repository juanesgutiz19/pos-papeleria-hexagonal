package com.ceiba.papeleria.venta.comando.fabrica;

import com.ceiba.papeleria.articulo.puerto.repositorio.RepositorioArticulo;
import com.ceiba.papeleria.venta.comando.ComandoDetalleVentaRegistrar;
import com.ceiba.papeleria.venta.comando.ComandoSolicitudRegistrar;
import com.ceiba.papeleria.venta.modelo.entidad.DetalleVenta;
import com.ceiba.papeleria.venta.modelo.entidad.SolicitudRegistrar;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class FabricaSolicitudRegistrar {

    private final RepositorioArticulo repositorioArticulo;

    public FabricaSolicitudRegistrar(RepositorioArticulo repositorioArticulo) {
        this.repositorioArticulo = repositorioArticulo;
    }

    public SolicitudRegistrar crear(ComandoSolicitudRegistrar comandoSolicitudRegistrar) {
        List<DetalleVenta> detallesVenta = obtenerDetallesVenta(comandoSolicitudRegistrar.getComandoDetallesVentaRegistrar());
        return new SolicitudRegistrar(comandoSolicitudRegistrar.getFecha(),
                detallesVenta
        );
    }

    private List<DetalleVenta> obtenerDetallesVenta(List<ComandoDetalleVentaRegistrar> comandoDetallesVentaRegistrar) {
        return comandoDetallesVentaRegistrar.stream().map(comandoDetalleVenta ->
                        DetalleVenta.crear(
                                comandoDetalleVenta.getCantidad(),
                                repositorioArticulo.obtener(comandoDetalleVenta.getIdArticulo())))
                .collect(Collectors.toList());
    }
}
