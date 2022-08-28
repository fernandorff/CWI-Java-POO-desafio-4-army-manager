package militar;

import habilitacoes.HabilitacaoHelicoptero;

import java.time.LocalDate;

public class PilotoHelicoptero extends Militar implements HabilitacaoHelicoptero {



    public PilotoHelicoptero(int salario, LocalDate validadeHabilitacaoHelicoptero) {

        super(salario);
        setDataDeValidadeHelicoptero(validadeHabilitacaoHelicoptero);
    }

    @Override
    public void setDataDeValidadeHelicoptero(LocalDate data) {

        this.validadeHabilitacaoHelicoptero = data;
    }



}
