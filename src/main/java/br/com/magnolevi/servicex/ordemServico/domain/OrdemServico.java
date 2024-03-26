package br.com.magnolevi.servicex.ordemServico.domain;


import br.com.magnolevi.servicex.pagamento.domain.Pagamento;
import br.com.magnolevi.servicex.servico.domain.Servico;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "ordem_servicos")
public class OrdemServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idOrdemServico;
    @Column(name = "data_solicitacao")
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm")
    private Date dataSolicitacao;
    @Column(name = "valor")
    private Double valorOrdemServico;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "ordemServico")
    private Pagamento pagamento;
    @ManyToMany
    @JoinTable(name = "servico_os_bridge", joinColumns = @JoinColumn(name = "os_id"), inverseJoinColumns = @JoinColumn(name = "servico_id"))
    private Set<Servico> servicos;
}
