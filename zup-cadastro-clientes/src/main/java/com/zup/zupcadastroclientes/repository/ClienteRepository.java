//Classe responsável por interagir com o banco de dados, cria, salva, busca, edita um cliente no banco de dados

package com.zup.zupcadastroclientes.repository;

import com.zup.zupcadastroclientes.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository //anotação que especifica que essa classe é do tipo repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
