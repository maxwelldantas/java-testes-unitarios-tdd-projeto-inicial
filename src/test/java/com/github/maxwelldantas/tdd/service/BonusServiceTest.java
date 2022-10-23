package com.github.maxwelldantas.tdd.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.Test;

import com.github.maxwelldantas.tdd.modelo.Funcionario;
import com.github.maxwelldantas.tdd.utils.TestReplaceCameCase;

@DisplayNameGeneration(TestReplaceCameCase.class)
class BonusServiceTest {

	@Test
	void testBonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		BonusService bonusService = new BonusService();
		BigDecimal calculaBonus = bonusService
				.calcularBonus(new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("25000")));

		assertEquals(new BigDecimal("0.00"), calculaBonus);
	}

	@Test
	void testBonusDeveriaSerDezPorcentoDoSalario() {
		BonusService bonusService = new BonusService();
		BigDecimal calculaBonus = bonusService
				.calcularBonus(new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), calculaBonus);
	}

	@Test
	void testBonusDeveriaSerDezPorCentoParaSalarioDeExatamenteDezMilReais() {
		BonusService bonusService = new BonusService();
		BigDecimal calculaBonus = bonusService
				.calcularBonus(new Funcionario("Maxwell Dantas", LocalDate.now(), new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), calculaBonus);
	}
}
