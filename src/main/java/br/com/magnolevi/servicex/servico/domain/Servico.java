package br.com.magnolevi.servicex.servico.domain;

import br.com.magnolevi.servicex.categoria.domain.Categoria;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
    @Column(name = "nome")
    private String nomeServico;
    @Column(name = "valor")
    private Double valorServico;
    @ManyToOne
    @JoinColumn(name = "id_categoria")
    private Categoria categoria;
}
