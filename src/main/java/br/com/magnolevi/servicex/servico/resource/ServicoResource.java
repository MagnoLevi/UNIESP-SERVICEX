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

    @GetMapping("/{id}")
    public ResponseEntity<Servico> show(@PathVariable Integer id){
        return servicoService.show(id)
                .map(servico -> new ResponseEntity(servico, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Integer id){
        servicoService.destroy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Servico> update(@PathVariable Integer id, @RequestBody Servico servico){
        if (!servicoService.show(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        servico.setIdServico(id);
        Servico novoServico = servicoService.update(servico);
        return new ResponseEntity<>(novoServico, HttpStatus.OK);
    }
}
