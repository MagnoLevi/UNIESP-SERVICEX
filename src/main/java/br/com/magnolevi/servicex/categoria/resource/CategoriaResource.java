package br.com.magnolevi.servicex.categoria.resource;

import br.com.magnolevi.servicex.categoria.domain.Categoria;
import br.com.magnolevi.servicex.categoria.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/categorias")
public class CategoriaResource {
    @Autowired
    private CategoriaService categoriaService;

    @PostMapping
    public ResponseEntity<Categoria> store(@RequestBody Categoria categoria){
        Categoria nova_categoria = categoriaService.store(categoria);
        return new ResponseEntity<>(nova_categoria, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Categoria>> index(){
        List<Categoria> data = categoriaService.index();
        return new ResponseEntity<>(data, HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Categoria> show(@PathVariable Integer id){
        return categoriaService.show(id)
                .map(categoria -> new ResponseEntity(categoria, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity(HttpStatus.NOT_FOUND));
    }
}
