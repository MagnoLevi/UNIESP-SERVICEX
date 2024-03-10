package br.com.magnolevi.servicex.categoria.domain;

import br.com.magnolevi.servicex.servico.domain.Servico;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id_categoria;
    @Column(name = "nome")
    private String nomeCategoria;
    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Servico> servicos;


}
