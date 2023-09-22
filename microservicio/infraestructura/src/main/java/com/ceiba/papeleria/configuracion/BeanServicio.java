package com.ceiba.papeleria.configuracion;


import com.ceiba.papeleria.factura.puerto.repositorio.RepositorioFactura;
import com.ceiba.papeleria.factura.servicio.ServicioAnular;
import com.ceiba.papeleria.factura.servicio.ServicioFacturar;
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


	

} 
