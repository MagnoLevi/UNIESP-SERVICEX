package br.com.magnolevi.servicex.servico.resource;

import br.com.magnolevi.servicex.servico.domain.Servico;
import br.com.magnolevi.servicex.servico.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/servico")
public class ServicoResource {
    @Autowired
    private ServicoService servicoService;

    @PostMapping
    public ResponseEntity<Servico> store(@RequestBody Servico servico){
        Servico novoServico = servicoService.store(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Servico>> index() {
        List<Servico> data = servicoService.index();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }
}
