package simulacao;

import erros.HabilitacaoExpiradaException;
import habilitacoes.HabilitacaoAviao;
import habilitacoes.HabilitacaoCaminhao;
import habilitacoes.HabilitacaoHelicoptero;
import habilitacoes.HabilitacaoTanque;
import veiculo.Veiculo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SimulacaoFinanceira {

    private int distanciaDaViagem;

    private final List<Veiculo> veiculosDaMissao = new ArrayList<>();

    private int meses;

    private int custoTotalDaMissao;

    private int custoDoCombustivelDaMissao;

    private int custoDosSalariosDaMissao;

    LocalDate dataFinalDaMissao;

    public SimulacaoFinanceira(int distanciaDaViagem, int meses, Veiculo... argsVeiculos) {

        this.distanciaDaViagem = distanciaDaViagem;
        this.meses = meses;

        this.dataFinalDaMissao = LocalDate.now().plusMonths(meses);

        Collections.addAll(veiculosDaMissao, argsVeiculos);

    }

    public void checarValidadeDasHabilitacoes() {

        for (Veiculo veiculo : veiculosDaMissao) {

            if (veiculo.getPiloto() instanceof HabilitacaoAviao && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoAviao())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo.getPiloto() instanceof HabilitacaoCaminhao && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoCaminhao())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo.getPiloto() instanceof HabilitacaoHelicoptero && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoHelicoptero())) {
                throw new HabilitacaoExpiradaException();
            }

            if (veiculo.getPiloto() instanceof HabilitacaoTanque && dataFinalDaMissao.isAfter(veiculo.getPiloto().getValidadeHabilitacaoTanque())) {
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

        custoTotalDaMissao = getCustoDoCombustivelDaMissao() + getCustoDosSalariosDaMissao();

        return custoTotalDaMissao;
    }

    public int getCustoDoCombustivelDaMissao() {

        custoDoCombustivelDaMissao = 0;

        for (Veiculo veiculo : veiculosDaMissao) {
            custoDoCombustivelDaMissao += veiculo.getKmPorLitro() * veiculo.getPrecoDoLitroDeCombustivel() * this.distanciaDaViagem;

        }

        return custoDoCombustivelDaMissao;

    }

    public int getCustoDosSalariosDaMissao() {

        custoDosSalariosDaMissao = 0;

        for (Veiculo veiculo : veiculosDaMissao) {
            custoDosSalariosDaMissao += veiculo.getCustoDosSalariosDaTripulacaoDoVeiculoPorMes() * meses;

        }

        return custoDosSalariosDaMissao;

    }

}
