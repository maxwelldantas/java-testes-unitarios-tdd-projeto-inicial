package com.github.maxwelldantas.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import com.github.maxwelldantas.tdd.modelo.Funcionario;
import com.github.maxwelldantas.tdd.utils.TestReplaceCameCase;

@DisplayNameGeneration(TestReplaceCameCase.class)
class BonusServiceTest {

    private BonusService bonusService;
    private Funcionario funcionario;

    @BeforeEach
    void setUp() {
	this.bonusService = new BonusService();
	this.funcionario = new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("25000"));
    }

    @Test
    void testBonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
	assertThrows(IllegalArgumentException.class, () -> bonusService.calcularBonus(this.funcionario));
    }

    @Test
    void testBonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAltoOutraFormaDeTestarException() {
	try {
	    bonusService.calcularBonus(this.funcionario);
	    fail("Não lançou a exception!");
	} catch (Exception e) {
	    assertEquals("Funcionario com salário maior que R$ 10000 não pode receber bonus!", e.getMessage());
	}
    }

    @Test
    void testBonusDeveriaSerDezPorcentoDoSalario() {
	BigDecimal calculaBonus = bonusService
		.calcularBonus(new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("2500")));

	assertEquals(new BigDecimal("250.00"), calculaBonus);
    }

    @Test
    void testBonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
	BigDecimal calculaBonus = bonusService
		.calcularBonus(new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("10000")));

	assertEquals(new BigDecimal("1000.00"), calculaBonus);
    }
}
