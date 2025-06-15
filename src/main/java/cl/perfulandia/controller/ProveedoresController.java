package cl.perfulandia.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.perfulandia.model.dto.ProveedoresDTO;
import cl.perfulandia.service.ProveedoresService;

@RestController
@RequestMapping("/proveedores")
public class ProveedoresController {

    @Autowired
    private ProveedoresService proveedoresService;

    @GetMapping
    public ResponseEntity<List<ProveedoresDTO>> findAll() {
        return ResponseEntity.ok(proveedoresService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProveedoresDTO> findById(@PathVariable Long id) {
        ProveedoresDTO dto = proveedoresService.findById(id);
        return (dto != null) ? ResponseEntity.ok(dto) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<ProveedoresDTO> save(@RequestBody ProveedoresDTO dto) {
        return ResponseEntity.status(201).body(proveedoresService.save(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProveedoresDTO> update(@PathVariable Long id, @RequestBody ProveedoresDTO dto) {
        return ResponseEntity.ok(proveedoresService.update(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        proveedoresService.delete(id);
        return ResponseEntity.noContent().build();
    }
}