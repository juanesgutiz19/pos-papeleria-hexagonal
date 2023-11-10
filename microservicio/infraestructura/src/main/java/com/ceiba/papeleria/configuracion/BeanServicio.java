package com.ceiba.papeleria.configuracion;


import com.ceiba.papeleria.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.papeleria.factura.servicio.ServicioAnular;
import com.ceiba.papeleria.factura.servicio.ServicioFacturar;
import com.ceiba.papeleria.inventario.puerto.repositorio.RepositorioInventario;
import com.ceiba.papeleria.inventario.servicio.ServicioActualizarCantidadDisponible;
import com.ceiba.papeleria.venta.puerto.repositorio.RepositorioVenta;
import com.ceiba.papeleria.venta.servicio.ServicioRegistrar;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanServicio {

    @Bean
    public ServicioFacturar servicioFacturar(RepositorioFactura repositorioFactura) {
        return new ServicioFacturar(repositorioFactura);
    }

    @Bean
    public ServicioAnular servicioAnular(RepositorioFactura repositorioFactura) {
        return new ServicioAnular(repositorioFactura);
    }

    @Bean
    public ServicioActualizarCantidadDisponible servicioActualizarCantidadDisponible(RepositorioInventario repositorioInventario) {
        return new ServicioActualizarCantidadDisponible(repositorioInventario);
    }

    @Bean
    public ServicioRegistrar servicioRegistrar(RepositorioVenta repositorioVenta) {
        return new ServicioRegistrar(repositorioVenta);
    }

} 
