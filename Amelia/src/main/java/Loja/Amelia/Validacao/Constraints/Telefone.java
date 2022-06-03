package Loja.Amelia.Validacao.Constraints;

import Loja.Amelia.Validacao.Validation.ContatoTelefoneValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Constraint(validatedBy = ContatoTelefoneValidator.class)
@Target( { ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface Telefone {

    String message() default "Número de telefone inválido !";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
