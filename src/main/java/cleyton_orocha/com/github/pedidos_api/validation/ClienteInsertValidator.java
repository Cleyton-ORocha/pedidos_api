package cleyton_orocha.com.github.pedidos_api.validation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Cliente;
import cleyton_orocha.com.github.pedidos_api.domain.enums.TipoCliente;
import cleyton_orocha.com.github.pedidos_api.domain.repository.ClienteRepository;
import cleyton_orocha.com.github.pedidos_api.exceptions.FieldMessage;
import cleyton_orocha.com.github.pedidos_api.rest.DTO.ClienteNewDTO;
import cleyton_orocha.com.github.pedidos_api.util.BR;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteInsertValidator implements ConstraintValidator<ClienteInsert, ClienteNewDTO> {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteInsert constraintAnnotation) {
    }

    @Override
    public boolean isValid(ClienteNewDTO clienteNewDto, ConstraintValidatorContext constraintValidatorContext) {
        List<FieldMessage> list = new ArrayList<>();

        if (clienteNewDto.getTipo().equals(TipoCliente.PESSOAFISICA.getCod())
                && !BR.isValidCpf(clienteNewDto.getCpfCnpj())) {
            list.add(new FieldMessage("cpfCnpj", "CPF Inválido."));
        }

        if (clienteNewDto.getTipo().equals(TipoCliente.PESSOAJURIDICA.getCod())
                && !BR.isValidCnpj(clienteNewDto.getCpfCnpj())) {
            list.add(new FieldMessage("cpfCnpj", "CNPJ Inválido."));
        }

        Cliente cliente = clienteRepository.findByEmail(clienteNewDto.getEmail());

        if (cliente != null) {
            list.add(new FieldMessage("email", "E-mail já existente."));
        }

        for (FieldMessage e : list) {
            constraintValidatorContext.disableDefaultConstraintViolation();
            constraintValidatorContext.buildConstraintViolationWithTemplate(e.getMessage())
                    .addPropertyNode(e.getFieldName()).addConstraintViolation();
        }

        return list.isEmpty();
    }

}
