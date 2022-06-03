package Loja.Amelia.Validacao.Validation;

import Loja.Amelia.Validacao.Constraints.Telefone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class ContatoTelefoneValidator implements ConstraintValidator<Telefone, String> {

    
    @Override
    public void initialize(Telefone telefone) {
        ConstraintValidator.super.initialize(telefone);
    }

    @Override
    public boolean isValid(String s, ConstraintValidatorContext valor) {
        return s.matches("^\\([1-9]{2}\\) (?:[2-8]|9[1-9])[0-9]{3}\\-[0-9]{4}$");
    }
}
