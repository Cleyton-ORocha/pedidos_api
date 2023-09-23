package cleyton_orocha.com.github.pedidos_api.domain.enums;

import java.util.stream.Stream;

public enum Perfil {
    ADMIN(1, "ROLE_ADMIN"),
    CLIENTE(2, "ROLE_CLIENTE");

    private Integer cod;
    private String descricao;

    Perfil(Integer cod, String descricao) {
        this.cod = cod;
        this.descricao = descricao;
    }

    public static Perfil toEnum(Integer cod) {
        return Stream.of(Perfil.values())
                .filter(f -> f.getCod().equals(cod))
                .findFirst()
                .orElseThrow(() -> new EnumConstantNotPresentException(Perfil.class,
                        "Código " + cod + " não encontrado."));
    }

    public Integer getCod() {
        return cod;
    }

    public String getDescricao() {
        return descricao;
    }
}
