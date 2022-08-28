package militar;

import habilitacoes.HabilitacaoAviao;
import habilitacoes.HabilitacaoHelicoptero;

import java.time.LocalDate;

public class EspecialistaAereo extends Militar implements HabilitacaoAviao, HabilitacaoHelicoptero {



    public EspecialistaAereo(int salario, LocalDate validadeHabilitacaoAviao, LocalDate validadeHabilitacaoHelicoptero) {

        super(salario);
        setDataDeValidadeAviao(validadeHabilitacaoAviao);
        setDataDeValidadeHelicoptero(validadeHabilitacaoHelicoptero);
    }

    @Override
    public void setDataDeValidadeAviao(LocalDate data) {

        this.validadeHabilitacaoAviao = data;
    }

    @Override
    public void setDataDeValidadeHelicoptero(LocalDate data) {

        this.validadeHabilitacaoHelicoptero = data;
    }

}
