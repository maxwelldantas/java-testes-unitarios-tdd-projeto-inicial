package com.github.maxwelldantas.tdd.service;

import java.math.BigDecimal;

import com.github.maxwelldantas.tdd.modelo.Desempenho;
import com.github.maxwelldantas.tdd.modelo.Funcionario;

public class ReajusteService {

    public void concederReajuste(Funcionario funcionario, Desempenho desempenho) {
	BigDecimal percentual = desempenho.percentualReajuste();
	BigDecimal reajuste = funcionario.getSalario().multiply(percentual);
	funcionario.reajustarSalaria(reajuste);
    }

}
