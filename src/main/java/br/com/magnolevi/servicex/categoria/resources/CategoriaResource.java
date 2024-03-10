package br.com.magnolevi.servicex.categoria.resources;

import br.com.magnolevi.servicex.categoria.domain.Categoria;
import br.com.magnolevi.servicex.categoria.services.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
