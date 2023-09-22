package com.ceiba.papeleria.infraestructura.jdbc;

public interface EjecutarBD<T> {
    T ejecutar();
}