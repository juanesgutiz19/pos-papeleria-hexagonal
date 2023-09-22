package com.ceiba.papeleria.cliente.puerto;

import com.ceiba.papeleria.cliente.entidad.Cliente;

public interface RepositorioCliente {

    Cliente obtener(Long id);
}
