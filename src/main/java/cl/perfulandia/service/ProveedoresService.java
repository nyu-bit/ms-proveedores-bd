package cl.perfulandia.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.perfulandia.model.dto.ProveedoresDTO;
import cl.perfulandia.model.entities.Proveedores;
import cl.perfulandia.model.repositories.ProveedoresRepository;

@Service
public class ProveedoresService { 
@Autowired
    private ProveedoresRepository proveedoresRepository;

    public List<ProveedoresDTO> findAll() {
        return proveedoresRepository.findAll().stream()
                .map(this::toDTO)
                .collect(Collectors.toList());
    }

    public ProveedoresDTO findById(Long id) {
        Optional<Proveedores> proveedor = proveedoresRepository.findById(id);
        return proveedor.map(this::toDTO).orElse(null);
    }

    public ProveedoresDTO save(ProveedoresDTO dto) {
        Proveedores saved = proveedoresRepository.save(toEntity(dto));
        return toDTO(saved);
    }

    public ProveedoresDTO update(Long id, ProveedoresDTO dto) {
        Proveedores proveedor = toEntity(dto);
        proveedor.setId(id);
        return toDTO(proveedoresRepository.save(proveedor));
    }

    public void delete(Long id) {
        proveedoresRepository.deleteById(id);
    }

    // Conversión
    private ProveedoresDTO toDTO(Proveedores p) {
        ProveedoresDTO dto = new ProveedoresDTO();
        dto.setId(p.getId());
        dto.setNombre(p.getNombre());
        dto.setContacto(p.getContacto());
        dto.setTipoProducto(p.getTipoProducto());
        return dto;
    }

    private Proveedores toEntity(ProveedoresDTO dto) {
        Proveedores p = new Proveedores();
        p.setId(dto.getId());
        p.setNombre(dto.getNombre());
        p.setContacto(dto.getContacto());
        p.setTipoProducto(dto.getTipoProducto());
        return p;
    }
}