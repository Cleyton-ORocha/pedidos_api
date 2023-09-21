package cleyton_orocha.com.github.pedidos_api.domain.entity;

import java.io.Serializable;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Locale;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;

@Entity
public class Pedido implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date instante;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "pedido")
    private Pagamento pagamento;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_de_entrega_id")
    private Endereco enderecoEntrega;

    @OneToMany(mappedBy = "id.pedido")
    private Set<ItemPedido> itens = new HashSet<>();

    public Pedido() {
    }

    public Pedido(Integer id, Date instante, Pagamento pagamento, Cliente cliente, Endereco enderecoEntrega) {
        this.id = id;
        this.instante = instante;
        this.pagamento = pagamento;
        this.cliente = cliente;
        this.enderecoEntrega = enderecoEntrega;
    }

    // TODO: Validar depois
    public Double getValorTotal() {

        return itens.stream()
                .mapToDouble(m -> m.getSubTotal())
                .sum();

        // return itens.stream()
        // .map(i -> i.getSubTotal())
        // .reduce(0.0, (a, i) -> a + i);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInstante() {
        return instante;
    }

    public void setInstante(Date instant) {
        this.instante = instant;
    }

    public Pagamento getPagamento() {
        return pagamento;
    }

    public void setPagamento(Pagamento pagamento) {
        this.pagamento = pagamento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(Endereco enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }

    public Set<ItemPedido> getItens() {
        return itens;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        Pedido pedido = (Pedido) o;
        return getId().equals(pedido.getId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }

    @Override
    public String toString() {
        NumberFormat numberFormat = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
        StringBuffer sb = new StringBuffer();
        sb.append("Pedido Número: " + getId())
                .append(", Instante: " + simpleDateFormat.format(getInstante()))
                .append(", Cliente: " + getCliente().getNome())
                .append(", Situação do pagamento: " + getPagamento().getEstado().getDescricao())
                .append("\nDetalhes:\n");
        for (ItemPedido ip : getItens()) {
            sb.append(ip.toString());
        }
        sb.append(", Valor total: " + numberFormat.format(getValorTotal()));
        return sb.toString();
    }

}
