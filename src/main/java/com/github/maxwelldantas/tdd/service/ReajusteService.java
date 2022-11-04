package com.github.maxwelldantas.tdd.service;

import java.math.BigDecimal;

import com.github.maxwelldantas.tdd.modelo.Desempenho;
import com.github.maxwelldantas.tdd.modelo.Funcionario;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
	if (desempenho == Desempenho.A_DESEJAR) {
	    BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.03"));
	    funcionario.reajustarSalaria(reajuste);
	} else if (desempenho == Desempenho.BOM) {
	    BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.15"));
	    funcionario.reajustarSalaria(reajuste);
	} else if (desempenho == Desempenho.OTIMO) {
	    BigDecimal reajuste = funcionario.getSalario().multiply(new BigDecimal("0.20"));
	    funcionario.reajustarSalaria(reajuste);
	}
    }

}
