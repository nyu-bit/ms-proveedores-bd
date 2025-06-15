package cl.perfulandia.model.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import cl.perfulandia.model.entities.Proveedores;

public interface ProveedoresRepository extends JpaRepository<Proveedores, Long> {
}