package cl.perfulandia.model.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class ProveedoresDTO {
    private Long id;
    private String nombre;
    private String contacto;
    private String tipoProducto;
}