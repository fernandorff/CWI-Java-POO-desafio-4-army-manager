import militar.*;
import org.junit.Assert;
import org.junit.Test;
import simulacao.SimulacaoFinanceira;
import veiculo.Aviao;
import veiculo.Caminhao;
import veiculo.Helicoptero;
import veiculo.Tanque;

import java.time.LocalDate;

public class SimulacaoFinanceiraTest {

    // Criando militares
    Militar soldado = new Militar(2000);

    PilotoAviao pilotoAviao = new PilotoAviao(9000, LocalDate.now().plusDays(100));

    PilotoTanque pilotoDeTanque = new PilotoTanque(5000, LocalDate.now().plusDays(100));

    PilotoCaminhao pilotoDeCaminhao = new PilotoCaminhao(3000, LocalDate.now().plusDays(100));

    PilotoHelicoptero pilotoHelicoptero = new PilotoHelicoptero(7000, LocalDate.now().plusDays(100));

    EspecialistaAereo expertAereo = new EspecialistaAereo(12000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    EspecialistaTerrestre expertTerra = new EspecialistaTerrestre(8000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    Elite elite = new Elite(16000, LocalDate.now().plusDays(100), LocalDate.now().plusDays(100), LocalDate.now().plusDays(100), LocalDate.now().plusDays(100));

    // Criando veiculos
    Tanque tanque = new Tanque(5, 10, expertTerra, pilotoDeTanque, soldado, soldado);

    Caminhao caminhao = new Caminhao(10, 10, pilotoDeCaminhao, elite, soldado, soldado, soldado, soldado, soldado);

    Aviao aviao = new Aviao(50, 20, elite, pilotoAviao);

    Helicoptero helicoptero = new Helicoptero(30, 20, pilotoHelicoptero, expertAereo, soldado, soldado, soldado);

    @Test
    public void deveCalcularOCustoTotalDaMissaoCorretamente() {

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviao, tanque, helicoptero, caminhao);

        Assert.assertEquals(3692000, simulacao.getCustoTotalDaMissao(), 0.0000001);

    }

    @Test
    public void deveCalcularOCustoTotalComCombustivelCorretamente(){

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviao, tanque, helicoptero, caminhao);

        Assert.assertEquals(3692000, simulacao.getCustoTotalDaMissao(), 0.0000001);

    }

    @Test
    public void deveCalcularOCustoToralComSalariosCorretamente(){

        SimulacaoFinanceira simulacao = new SimulacaoFinanceira(2000, 2, aviao, tanque, helicoptero, caminhao);

        Assert.assertEquals(3692000, simulacao.getCustoTotalDaMissao(), 0.0000001);

    }

}
