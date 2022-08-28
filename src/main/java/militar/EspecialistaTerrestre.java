package militar;

import habilitacoes.HabilitacaoCaminhao;
import habilitacoes.HabilitacaoTanque;

import java.time.LocalDate;

public class EspecialistaTerrestre extends Militar implements HabilitacaoCaminhao, HabilitacaoTanque {

    public EspecialistaTerrestre(int salario, LocalDate validadeHabilitacaoCaminhao, LocalDate validadeHabilitacaoTanque) {

        super(salario);
        setDataDeValidadeCaminhao(validadeHabilitacaoCaminhao);
        setDataDeValidadeTanque(validadeHabilitacaoTanque);
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
