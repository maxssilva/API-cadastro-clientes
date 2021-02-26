/*      Essa classe recebe, trata e e devolve as requisições HTTP, devolvendo uma resposta na sequência, normalmente criada em um pacote de  "nome.controller"

            , essencialmente é uma classe de controle Rest, classe que recebe requisições para desenvolver os endpoints REST da aplicação*/

package com.zup.zupcadastroclientes.controller;

import com.zup.zupcadastroclientes.model.Cliente;
import com.zup.zupcadastroclientes.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController// anotação de conveniência que anota como @Controller @ResponseBody
@RequestMapping("/clientes")//as requisições que sejam terminadas com "/clientes" sejam direcionadas para esse controlador
public class ClienteController {

    @Autowired//anotação que injeta uma instância de ClienteRepository em clienteRepository
    private ClienteRepository clienteRepository;

    @GetMapping//as requisições do tipo Get marcadas com "/clientes" levam a esse método que responderá a essa requisição
    public List<Cliente> listar(){
        return clienteRepository.findAll();
        }
    @PostMapping//nesse caso as requisições do tipo Post trazem a este método "adicionar"
    @ResponseStatus(HttpStatus.CREATED)//troca a resposta status para o codigo padrão 201 Created
    public Cliente adicionar(@RequestBody Cliente cliente){//o @RequestBody anota o parametro cliiente com RequestBody, dizendo que o corpo da requição (JSON), será convertido em um objeto java do tipo CLiente
        return clienteRepository.save(cliente);
    }
}
