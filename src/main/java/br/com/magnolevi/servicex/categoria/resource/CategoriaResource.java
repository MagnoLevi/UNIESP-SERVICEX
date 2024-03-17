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
        Categoria novaCategoria = categoriaService.store(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.CREATED);
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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> destroy(@PathVariable Integer id){
        categoriaService.destroy(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }


    @PutMapping("/{id}")
    public ResponseEntity<Categoria> update(@PathVariable Integer id, @RequestBody Categoria categoria){
        if (!categoriaService.show(id).isPresent()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        categoria.setIdCategoria(id);
        Categoria novaCategoria = categoriaService.update(categoria);
        return new ResponseEntity<>(novaCategoria, HttpStatus.OK);
    }
}
