package cleyton_orocha.com.github.pedidos_api.domain.enums;

import java.util.stream.Stream;

public enum EstadoPagamento {

    PENDENTE(1, "Pendente"),
    QUITADO(2, "Quitado"),
    CANCELADO(3, "Cancelado");

    private Integer cod;
    private String descricao;

    EstadoPagamento(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static EstadoPagamento toEnum(Integer cod) {
        return Stream.of(EstadoPagamento.values())
                .filter(f -> f.getCod().equals(cod))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(EstadoPagamento.class,
                        "Código " + cod + " não encontrado."));
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
