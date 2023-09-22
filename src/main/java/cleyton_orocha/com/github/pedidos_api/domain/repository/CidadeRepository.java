package cleyton_orocha.com.github.pedidos_api.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import cleyton_orocha.com.github.pedidos_api.domain.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {
}