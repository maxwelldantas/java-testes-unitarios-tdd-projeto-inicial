package com.github.maxwelldantas.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import com.github.maxwelldantas.tdd.modelo.Desempenho;
import com.github.maxwelldantas.tdd.modelo.Funcionario;
import com.github.maxwelldantas.tdd.utils.TestReplaceCameCase;

@DisplayNameGeneration(TestReplaceCameCase.class)
class ReajusteServiceTest {

    @Test
    void testReajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
	ReajusteService service = new ReajusteService();
	Funcionario funcionario = new Funcionario("Ana", LocalDate.now(), new BigDecimal("1000.00"));

	service.concederReajuste(funcionario, Desempenho.A_DESEJAR);

	assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void testReajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
	ReajusteService service = new ReajusteService();
	Funcionario funcionario = new Funcionario("Joana", LocalDate.now(), new BigDecimal("1000.00"));

	service.concederReajuste(funcionario, Desempenho.BOM);

	assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void testReajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
	ReajusteService service = new ReajusteService();
	Funcionario funcionario = new Funcionario("Mariza", LocalDate.now(), new BigDecimal("1000.00"));

	service.concederReajuste(funcionario, Desempenho.OTIMO);

	assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
