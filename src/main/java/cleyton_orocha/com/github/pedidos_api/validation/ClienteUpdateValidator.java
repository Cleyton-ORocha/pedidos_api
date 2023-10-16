package cleyton_orocha.com.github.pedidos_api.validation;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerMapping;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Cliente;
import cleyton_orocha.com.github.pedidos_api.domain.repository.ClienteRepository;
import cleyton_orocha.com.github.pedidos_api.exceptions.FieldMessage;
import cleyton_orocha.com.github.pedidos_api.rest.DTO.ClienteUpdateDTO;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ClienteUpdateValidator implements ConstraintValidator<ClienteUpdate, ClienteUpdateDTO> {

    @Autowired
    private HttpServletRequest httpServletRequest;

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public void initialize(ClienteUpdate constraintAnnotation) {

    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean isValid(ClienteUpdateDTO clienteUpdateDto, ConstraintValidatorContext constraintValidatorContext) {
        Map<String, String> map = (Map<String, String>) httpServletRequest
                .getAttribute(HandlerMapping.URI_TEMPLATE_VARIABLES_ATTRIBUTE);
        Integer uriId = Integer.parseInt(map.get("id"));

        List<FieldMessage> list = new ArrayList<>();

        Cliente cliente = clienteRepository.findByEmail(clienteUpdateDto.getEmail());

        if (cliente != null && !cliente.getId().equals(uriId)) {
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
