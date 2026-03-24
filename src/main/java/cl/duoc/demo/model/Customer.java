package cl.duoc.demo.model;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Customer {
    @NotNull(message = "ID es obligatorio")
    private int id;
    @NotBlank(message = "Nombre es obligatorio")
    private String name;

    @NotBlank(message = "Email es obligatorio")
    @Email(message = "Email debe ser válido")
    private String email;
    @NotBlank(message = "Teléfono es obligatorio")
    private String phone;
}
