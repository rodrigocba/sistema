package com.birra.sistema.repository;

import com.birra.sistema.entity.Empleado;
import com.birra.sistema.entity.Fabrica;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;

public interface EmpleadoRepo extends JpaRepository<Empleado, Long> {

    void deleteEmpleadoById(Long id);

    Optional<Empleado> findEmpleadoById(Long id);
    Optional<Empleado> findEmpleadoByNombre(String nombre);



    Optional<Empleado> findEmpleadoByFabrica(Fabrica fabrica);


}
