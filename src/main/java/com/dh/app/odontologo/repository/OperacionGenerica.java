package com.dh.app.odontologo.repository;

import com.dh.app.odontologo.model.Odontologo;

import java.util.List;

public interface OperacionGenerica<T> {

     T crear(T t);

     List<T> listarOdontologos();

}
