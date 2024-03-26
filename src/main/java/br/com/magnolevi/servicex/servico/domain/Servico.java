package br.com.magnolevi.servicex.servico.domain;

import br.com.magnolevi.servicex.categoria.domain.Categoria;
import br.com.magnolevi.servicex.ordemServico.domain.OrdemServico;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "servicos")
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer idServico;
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;
    @Column(name = "nome")
    private String nomeServico;
    @Column(name = "valor")
    private Double valorServico;
    @ManyToMany
    private List<OrdemServico> ordermServicos;
}
