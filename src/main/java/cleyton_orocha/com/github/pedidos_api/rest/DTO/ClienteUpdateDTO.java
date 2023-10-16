package cleyton_orocha.com.github.pedidos_api.rest.DTO;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import cleyton_orocha.com.github.pedidos_api.validation.ClienteUpdate;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@ClienteUpdate
public class ClienteUpdateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    @NotEmpty(message = "Campo NOME é de preenchimento obrigatório.")
    @Length(min = 5, max = 80, message = "O tamanho do campo NOME deve ser entre 5 e 80 caracteres.")
    private String nome;

    @NotEmpty(message = "Campo E_MAIL é de preenchimento obrigatório.")
    @Email(message = "Campo E-mail inválido.")
    private String email;

    public ClienteUpdateDTO(Integer id, String nome, String email) {
        this.id = id;
        this.nome = nome;
        this.email = email;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}


