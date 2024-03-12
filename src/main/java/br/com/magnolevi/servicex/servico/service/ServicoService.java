package br.com.magnolevi.servicex.servico.service;

import br.com.magnolevi.servicex.servico.domain.Servico;
import br.com.magnolevi.servicex.servico.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService {
    @Autowired
    private ServicoRepository servicoRepository;

    /**
     * Armazena um servico
     * @param servico
     * @return
     */
    public Servico store(Servico servico){
        return servicoRepository.save(servico);
    }

    /**
     * Atualiza um servico
     * @param servico
     * @return
     */
    public Servico update(Servico servico) {
        return servicoRepository.save(servico);
    }

    /**
     * Deleta um servico por id
     * @param id
     */
    public void destroy(Integer id){
        servicoRepository.deleteById(id);
    }

    /**
     * Lista todos os serviços
     * @return
     */
    public List<Servico> index(){
        return servicoRepository.findAll();
    }

    /**
     * Busca um serviço por id
     * @param id
     */
    public Optional<Servico> show(Integer id){
        return servicoRepository.findById(id);
    }
}
