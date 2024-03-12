package br.com.magnolevi.servicex.categoria.service;

import br.com.magnolevi.servicex.categoria.domain.Categoria;
import br.com.magnolevi.servicex.categoria.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {
    @Autowired
    private CategoriaRepository categoriaRepository;

    /**
     * Armazena uma categoria
     * @param categoria
     * @return
     */
    public Categoria store(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * Atualiza uma categoria
     * @param categoria
     * @return
     */
    public Categoria update(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    /**
     * Deleta uma categoria por id
     * @param id
     */
    public void destroy(Integer id){
        categoriaRepository.deleteById(id);
    }

    /**
     * Lista todas as categorias
     * @return
     */
    public List<Categoria> index(){
        return categoriaRepository.findAll();
    }

    /**
     * Busca uma categoria por id
     * @param id
     * @return
     */
    public Optional<Categoria> show(Integer id){
        return categoriaRepository.findById(id);
    }
}

