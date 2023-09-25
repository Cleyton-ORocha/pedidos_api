package cleyton_orocha.com.github.pedidos_api.rest.DTO;

import java.io.Serializable;
import java.math.BigDecimal;

public class ProdutoDTO implements Serializable {
    private static final long serialVersionUID = 1L;

    private Integer id;
    private String nome;
    private BigDecimal preco;

    public ProdutoDTO() {
    }

    public ProdutoDTO(Integer id, String nome, BigDecimal preco) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
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

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }

    

}
