package simulacao;

import erros.HabilitacaoExpiradaException;
import habilitacoes.*;
import veiculo.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulacaoFinanceira {

    private int distanciaDaViagem;

    private final List<Veiculo> veiculosDaMissao = new ArrayList<>();

    private int meses;

    LocalDate dataFinalDaMissao;

    public SimulacaoFinanceira(int distanciaDaViagem, int meses, Veiculo... argsVeiculos) {

        this.distanciaDaViagem = distanciaDaViagem;
        this.meses = meses;

        this.dataFinalDaMissao = LocalDate.now().plusMonths(meses);

        Collections.addAll(veiculosDaMissao, argsVeiculos);

    }

    public void checarValidadeDasHabilitacoes() {

        for (Veiculo veiculo : veiculosDaMissao) {

            if (veiculo instanceof Aviao && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoAviao())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo instanceof Caminhao && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoCaminhao())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo instanceof Helicoptero && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoHelicoptero())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo instanceof Tanque && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoTanque())) {
                throw new HabilitacaoExpiradaException();

            }

        }

    }

    public void todasTripulacoesValidas() {

        for (Veiculo veiculo : veiculosDaMissao) {
            veiculo.tripulacaoValida();

        }
    }

    public int getCustoTotalDaMissao() {

        this.checarValidadeDasHabilitacoes();

        this.todasTripulacoesValidas();

        return getCustoDoCombustivelDaMissao() + getCustoDosSalariosDaMissao();


    }

    public int getCustoDoCombustivelDaMissao() {

        int custoDoCombustivelDaMissao = 0;

        for (Veiculo veiculo : veiculosDaMissao) {
            custoDoCombustivelDaMissao += veiculo.getKmPorLitro() * veiculo.getPrecoDoLitroDeCombustivel() * this.distanciaDaViagem;

        }

        return custoDoCombustivelDaMissao;

    }

    public int getCustoDosSalariosDaMissao() {

        int custoDosSalariosDaMissao = 0;

        for (Veiculo veiculo : veiculosDaMissao) {
            custoDosSalariosDaMissao += veiculo.getCustoDosSalariosDaTripulacaoDoVeiculoPorMes() * meses;

        }

        return custoDosSalariosDaMissao;

    }

}
