package cleyton_orocha.com.github.pedidos_api.domain.enums;

import java.util.stream.Stream;

public enum TipoCliente {
    PESSOAFISICA(1, "Pessoa Física"),
    PESSOAJURIDICA(2, "Pessoa Jurídica");

    private final Integer cod;
    private final String description;

    private TipoCliente(Integer cod, String description) {
        this.cod = cod;
        this.description = description;
    }

    public static TipoCliente toEnum(Integer cod) {

        return Stream.of(TipoCliente.values())
                .filter(f -> f.getCod().equals(cod))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(TipoCliente.class,
                        "Código " + cod + " não encontrado."));

    }

    public Integer getCod() {
        return cod;
    }

    public String getDescription() {
        return description;
    }

}
