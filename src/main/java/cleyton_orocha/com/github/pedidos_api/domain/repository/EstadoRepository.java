package cleyton_orocha.com.github.pedidos_api.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Estado;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Integer> {
}
