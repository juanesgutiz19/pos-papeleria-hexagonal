package com.ceiba.papeleria.factura.puerto.dao;

import com.ceiba.papeleria.factura.modelo.dto.ResumenFacturaDTO;

import java.util.List;

public interface DaoFactura {

    List<ResumenFacturaDTO> obtenerResumenDeFacturasAnuladas();
}
