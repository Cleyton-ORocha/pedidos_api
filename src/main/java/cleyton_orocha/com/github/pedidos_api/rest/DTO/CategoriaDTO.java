package cleyton_orocha.com.github.pedidos_api.rest.DTO;

import java.io.Serializable;

import org.hibernate.validator.constraints.Length;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Categoria;
import jakarta.validation.constraints.NotEmpty;

public class CategoriaDTO implements Serializable {

    private static final long serialVersionUUID = 1L;

    private Integer id;
    @NotEmpty(message = "Campo categoria é de preenchimento obrigatório")
    @Length(min = 5, max = 80, message = "O tamanho do campo categoria deve ser entre 5 e 80 caracteres")
    private String nome;

    public CategoriaDTO() {
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
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

}