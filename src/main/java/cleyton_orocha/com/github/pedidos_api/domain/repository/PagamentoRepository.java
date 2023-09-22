package cleyton_orocha.com.github.pedidos_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento, Integer> {
}
