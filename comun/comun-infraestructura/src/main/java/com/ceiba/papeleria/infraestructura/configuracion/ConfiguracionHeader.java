package com.ceiba.papeleria.infraestructura.configuracion;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import com.ceiba.papeleria.infraestructura.filtro.FiltroHeaderSeguridad;

@Configuration
public class ConfiguracionHeader {
	
	@Bean
	public FiltroHeaderSeguridad filtroHeader() {
		return new FiltroHeaderSeguridad();
	}

}