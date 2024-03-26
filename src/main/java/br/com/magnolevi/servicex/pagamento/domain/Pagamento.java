package br.com.magnolevi.servicex.pagamento.domain;

import br.com.magnolevi.servicex.ordemServico.domain.OrdemServico;
import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "pagamento")
public class Pagamento {
    @Id
    private Integer idPagamento;
    @Column(name = "status")
    private Integer statusPagamento;
    @OneToOne
    @JoinColumn(name = "os_id")
    @MapsId
    private OrdemServico ordemServico;

    public Pagamento(Integer idPagamento, StatusPagamento statusPagamento, OrdemServico ordermServico){
        this.idPagamento = idPagamento;
        this.statusPagamento = (statusPagamento == null) ? null : statusPagamento.getCod();
        this.ordemServico = ordermServico;
    }

    public Pagamento(){

    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public StatusPagamento getStatusPagamento() {
        return StatusPagamento.toEnum(statusPagamento);
    }

    public void setStatusPagamento(StatusPagamento statusPagamento) {
        this.statusPagamento = statusPagamento.getCod();
    }

    public OrdemServico getOrdermServico() {
        return ordemServico;
    }

    public void setOrdermServico(OrdemServico ordermServico) {
        this.ordemServico = ordermServico;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(idPagamento, pagamento.idPagamento) && Objects.equals(statusPagamento, pagamento.statusPagamento) && Objects.equals(ordemServico, pagamento.ordemServico);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idPagamento, statusPagamento, ordemServico);
    }
}
