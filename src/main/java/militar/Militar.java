package militar;

import java.time.LocalDate;

public class Militar {

    LocalDate validadeHabilitacaoTanque;

    LocalDate validadeHabilitacaoCaminhao;

    LocalDate validadeHabilitacaoHelicoptero;

    LocalDate validadeHabilitacaoAviao;

    int salario;

    public Militar(int salario) {

        this.salario = salario;
    }

    public int getSalario() {

        return salario;
    }

    public LocalDate getValidadeHabilitacaoHelicoptero() {

        return validadeHabilitacaoHelicoptero;
    }

    public LocalDate getValidadeHabilitacaoAviao() {

        return validadeHabilitacaoAviao;
    }

    public LocalDate getValidadeHabilitacaoCaminhao() {

        return validadeHabilitacaoCaminhao;
    }

    public LocalDate getValidadeHabilitacaoTanque() {

        return validadeHabilitacaoTanque;
    }

}
