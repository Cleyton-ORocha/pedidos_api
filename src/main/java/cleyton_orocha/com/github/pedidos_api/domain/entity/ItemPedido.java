package cleyton_orocha.com.github.pedidos_api.domain.entity;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Entity;

@Entity
public class ItemPedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @JsonIgnore

    private ItemPedidoPK id = new ItemPedidoPK();
    private Double desconto;
    private Integer quantidade;
    private Double preco;

    public ItemPedido() {
    }

    public ItemPedido(ItemPedidoPK id, Double desconto, Integer quantidade, Double preco) {
    
        this.desconto = desconto;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Double getSubTotal(){
        return (preco * desconto) * quantidade;
    }

    
}
