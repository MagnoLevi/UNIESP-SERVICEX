package br.com.magnolevi.servicex.pagamento.domain;

import br.com.magnolevi.servicex.ordemServico.domain.OrdemServico;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonTypeName;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@Entity
@JsonTypeName("pagamentoBoleto")
public class PagamentoBoleto extends Pagamento {
    @Column(name = "data_vencimento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataVencimento;
    @Column(name = "data_pagamento")
    @JsonFormat(pattern = "dd/MM/yyyy")
    private Date dataPagamento;

    public PagamentoBoleto(Integer idPagamento, StatusPagamento statusPagamento, OrdemServico ordermServico, Date dataVencimento, Date dataPagamento) {
        super(idPagamento, statusPagamento, ordermServico);
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }

    public PagamentoBoleto(Date dataVencimento, Date dataPagamento) {
        this.dataVencimento = dataVencimento;
        this.dataPagamento = dataPagamento;
    }
}
