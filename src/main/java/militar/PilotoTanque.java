package militar;

import habilitacoes.HabilitacaoTanque;

import java.time.LocalDate;

public class PilotoTanque extends Militar implements HabilitacaoTanque {

    public PilotoTanque(int salario, LocalDate validadeHabilitacaoTanque) {

        super(salario);
        setDataDeValidadeTanque(validadeHabilitacaoTanque);
    }

    @Override
    public void setDataDeValidadeTanque(LocalDate data) {

        this.validadeHabilitacaoTanque = data;
    }

}
