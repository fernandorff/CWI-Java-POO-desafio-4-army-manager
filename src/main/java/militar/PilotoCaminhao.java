package militar;

import habilitacoes.HabilitacaoCaminhao;

import java.time.LocalDate;

public class PilotoCaminhao extends Militar implements HabilitacaoCaminhao {


    public PilotoCaminhao(int salario, LocalDate validadeHabilitacaoCaminhao) {

        super(salario);
        setDataDeValidadeCaminhao(validadeHabilitacaoCaminhao);
    }

    @Override
    public void setDataDeValidadeCaminhao(LocalDate data) {

        this.validadeHabilitacaoCaminhao = data;

    }



}
