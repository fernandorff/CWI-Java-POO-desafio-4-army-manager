package militar;

import habilitacoes.HabilitacaoAviao;

import java.time.LocalDate;

public class PilotoAviao extends Militar implements HabilitacaoAviao {

    public PilotoAviao(int salario, LocalDate validadeHabilitacaoAviao) {

        super(salario);
        setDataDeValidadeAviao(validadeHabilitacaoAviao);
    }

    @Override
    public void setDataDeValidadeAviao(LocalDate data) {

        this.validadeHabilitacaoAviao = data;
    }

}
