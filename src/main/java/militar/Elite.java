package militar;

import habilitacoes.HabilitacaoAviao;
import habilitacoes.HabilitacaoCaminhao;
import habilitacoes.HabilitacaoHelicoptero;
import habilitacoes.HabilitacaoTanque;

import java.time.LocalDate;

public class Elite extends Militar implements HabilitacaoAviao, HabilitacaoHelicoptero, HabilitacaoCaminhao, HabilitacaoTanque {


    public Elite(int salario, LocalDate validadeHabilitacaoAviao, LocalDate validadeHabilitacaoHelicoptero, LocalDate validadeHabilitacaoCaminhao, LocalDate validadeHabilitacaoTanque) {

        super(salario);
        setDataDeValidadeAviao(validadeHabilitacaoAviao);
        setDataDeValidadeHelicoptero(validadeHabilitacaoHelicoptero);
        setDataDeValidadeCaminhao(validadeHabilitacaoCaminhao);
        setDataDeValidadeTanque(validadeHabilitacaoTanque);
    }

    @Override
    public void setDataDeValidadeAviao(LocalDate data) {

        this.validadeHabilitacaoAviao = data;
    }

    @Override
    public void setDataDeValidadeHelicoptero(LocalDate data) {

        this.validadeHabilitacaoHelicoptero = data;
    }

    @Override
    public void setDataDeValidadeCaminhao(LocalDate data) {

        this.validadeHabilitacaoCaminhao = data;
    }

    @Override
    public void setDataDeValidadeTanque(LocalDate data) {

        this.validadeHabilitacaoTanque = data;
    }

}
