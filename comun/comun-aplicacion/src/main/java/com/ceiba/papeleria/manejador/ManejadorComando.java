package com.ceiba.papeleria.manejador;

import org.springframework.transaction.annotation.Transactional;

public interface ManejadorComando<C> {

	@Transactional
	void ejecutar(C comando);
}