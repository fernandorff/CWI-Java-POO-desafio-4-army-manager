import erros.HabilitacaoExpiradaException;
import erros.TripulacaoInvalidaException;
import militar.*;
import org.junit.Assert;
import org.junit.Test;
import simulacao.SimulacaoFinanceira;
import veiculo.Aviao;
import veiculo.Caminhao;
import veiculo.Helicoptero;
import veiculo.Tanque;

import java.time.LocalDate;

public class TestesObrigatorios {

    // Criando militares
    Militar soldado = new Militar(2000);

    PilotoAviao pilotoAviao = new PilotoAviao(9000, LocalDate.now().plusDays(100));

    PilotoTanque pilotoTanque = new PilotoTanque(5000, LocalDate.now().plusDays(100));

    PilotoCaminhao pilotoCaminhao = new PilotoCaminhao(3000, LocalDate.now().plusDays(100));

    PilotoHelicoptero pilotoHelicoptero = new PilotoHelicoptero(7000, LocalDate.now().plusDays(100));

    EspecialistaAereo especialistaAereo = new EspecialistaAereo(12000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    EspecialistaTerrestre especialistaTerrestre = new EspecialistaTerrestre(8000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    Elite elite = new Elite(16000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100), LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    // Criando Tanques
    Tanque tanqueComPilotoDeTanque = new Tanque(5, 10, pilotoTanque, soldado, soldado, soldado);

    Tanque tanqueComEspecialistaTerrestre = new Tanque(5, 10, especialistaTerrestre, soldado, soldado, soldado);

    Tanque tanqueComElite = new Tanque(5, 10, elite, soldado, soldado, soldado);

    // Criando Caminhoes
    Caminhao caminhaoComPilotoDeCaminhao = new Caminhao(10, 10, pilotoCaminhao, soldado, soldado, soldado, soldado, soldado);

    Caminhao caminhaoComEspecialistaTerrestre = new Caminhao(10, 10, especialistaTerrestre, soldado, soldado, soldado, soldado, soldado);

    Caminhao caminhaoComElite = new Caminhao(10, 10, elite, soldado, soldado, soldado, soldado, soldado);

    // Criando Avioes
    Aviao aviaoComPilotoDeAviao = new Aviao(50, 20, pilotoAviao, soldado);

    Aviao aviaoComEspecialistaAereo = new Aviao(50, 20, especialistaAereo, soldado);

    Aviao aviaoComElite = new Aviao(50, 20, elite, soldado);

    // Criando Helicopteros
    Helicoptero helicopteroComPilotoDeHelicoptero = new Helicoptero(30, 20, pilotoHelicoptero, soldado, soldado);

    Helicoptero helicopteroComEspecialistaAereo = new Helicoptero(30, 20, especialistaAereo, soldado, soldado);

    Helicoptero helicopteroComElite = new Helicoptero(30, 20, elite, soldado, soldado);

    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviaoComPilotoDeAviao, aviaoComEspecialistaAereo, aviaoComElite, caminhaoComPilotoDeCaminhao, caminhaoComEspecialistaTerrestre, caminhaoComElite, helicopteroComPilotoDeHelicoptero, helicopteroComEspecialistaAereo, helicopteroComElite, tanqueComPilotoDeTanque, tanqueComEspecialistaTerrestre, tanqueComElite);

        Assert.assertEquals(10888000, simulacao.getCustoTotalDaMissao(), 0.0000001);

    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviaoComPilotoDeAviao, aviaoComEspecialistaAereo, aviaoComElite, caminhaoComPilotoDeCaminhao, caminhaoComEspecialistaTerrestre, caminhaoComElite, helicopteroComPilotoDeHelicoptero, helicopteroComEspecialistaAereo, helicopteroComElite, tanqueComPilotoDeTanque, tanqueComEspecialistaTerrestre, tanqueComElite);



        Assert.assertEquals(10500000, simulacao.getCustoDoCombustivelDaMissao(), 0.0000001);

    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviaoComPilotoDeAviao, aviaoComEspecialistaAereo, aviaoComElite, caminhaoComPilotoDeCaminhao, caminhaoComEspecialistaTerrestre, caminhaoComElite, helicopteroComPilotoDeHelicoptero, helicopteroComEspecialistaAereo, helicopteroComElite, tanqueComPilotoDeTanque, tanqueComEspecialistaTerrestre, tanqueComElite);



        Assert.assertEquals(388000, simulacao.getCustoDosSalariosDaMissao(), 0.0000001);

    }

    @Test(expected = TripulacaoInvalidaException.class)
    public void deveRetornarErroQuandoTripulacaoDoTanqueInvalida() {

        Tanque tanqueBugado = new Tanque(10, 10, elite, soldado, soldado);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 2, tanqueBugado);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = TripulacaoInvalidaException.class)
    public void deveRetornarErroQuandoTripulacaoDoCaminhaoInvalida() {

        Caminhao caminhaoBugado = new Caminhao(10, 10, elite, soldado, soldado,soldado,soldado);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 2, caminhaoBugado);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = TripulacaoInvalidaException.class)
    public void deveRetornarErroQuandoTripulacaoDoCaminhaoInvalidaExcessiva() {

        Caminhao caminhaoBugado = new Caminhao(10, 10, elite, soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado,soldado, soldado,soldado,soldado);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 2, caminhaoBugado);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = TripulacaoInvalidaException.class)
    public void deveRetornarErroQuandoTripulacaoDoHelicopteroInvalida() {

        Helicoptero helicopteroBugado = new Helicoptero(10, 10, elite, soldado, soldado, soldado, soldado, soldado, soldado, soldado, soldado, soldado, soldado, soldado, soldado);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 2, helicopteroBugado);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = TripulacaoInvalidaException.class)
    public void deveRetornarErroQuandoTripulacaoDoAviaoInvalida() {

        Aviao aviaoBugado = new Aviao(10, 10, elite, soldado, soldado);

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 2, aviaoBugado);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = HabilitacaoExpiradaException.class)
    public void deveRetornarErroQuandoHabilitacaoDoTanqueNaoTemValidadeSuficienteParaMissao() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 5, tanqueComPilotoDeTanque);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = HabilitacaoExpiradaException.class)
    public void deveRetornarErroQuandoHabilitacaoDoCaminhaoNaoTemValidadeSuficienteParaMissao() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 5, caminhaoComPilotoDeCaminhao);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = HabilitacaoExpiradaException.class)
    public void deveRetornarErroQuandoHabilitacaoDoHelicopteroNaoTemValidadeSuficienteParaMissao() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 5, helicopteroComPilotoDeHelicoptero);

        simulacao.getCustoTotalDaMissao();
    }

    @Test(expected = HabilitacaoExpiradaException.class)
    public void deveRetornarErroQuandoHabilitacaoDoAviaoNaoTemValidadeSuficienteParaMissao() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(1000, 5, aviaoComPilotoDeAviao);

        simulacao.getCustoTotalDaMissao();
    }




}
