package com.github.maxwelldantas.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import com.github.maxwelldantas.tdd.modelo.Desempenho;
import com.github.maxwelldantas.tdd.modelo.Funcionario;
import com.github.maxwelldantas.tdd.utils.TestReplaceCameCase;

@DisplayNameGeneration(TestReplaceCameCase.class)
class ReajusteServiceTest {

    private ReajusteService service;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
	this.service = new ReajusteService();
	this.funcionario = new Funcionario("Mariza", LocalDate.now(), new BigDecimal("1000.00"));
    }

    @Test
    void testReajusteDeveriaSerDeTresPorcentoQuandoDesempenhoForADesejar() {
	service.concederReajuste(this.funcionario, Desempenho.A_DESEJAR);
	assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
    }

    @Test
    void testReajusteDeveriaSerDeQuinzePorcentoQuandoDesempenhoForBom() {
	service.concederReajuste(this.funcionario, Desempenho.BOM);
	assertEquals(new BigDecimal("1150.00"), funcionario.getSalario());
    }

    @Test
    void testReajusteDeveriaSerDeVintePorcentoQuandoDesempenhoForOtimo() {
	service.concederReajuste(this.funcionario, Desempenho.OTIMO);
	assertEquals(new BigDecimal("1200.00"), funcionario.getSalario());
    }
}
