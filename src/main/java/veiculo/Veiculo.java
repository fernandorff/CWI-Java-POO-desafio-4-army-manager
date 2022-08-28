package veiculo;

import erros.TripulacaoInvalidaException;
import militar.Militar;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

public class Veiculo {

    LocalDate dataDeHabilitacaoPiloto;

    public List<Militar> tripulacao = new ArrayList<>();

    Militar piloto;

    double kmPorLitro;

    double precoDoLitroDeCombustivel;

    int custoDoVeiculoPorMes;

    public Veiculo(double kmPorLitro, double precoDoLitroDeCombustivel, Militar piloto, Militar... argsTripulantes) {

        this.kmPorLitro = kmPorLitro;
        this.precoDoLitroDeCombustivel = precoDoLitroDeCombustivel;
        this.piloto = piloto;
        Collections.addAll(tripulacao, argsTripulantes);

    }

    public void tripulacaoValida() {

        if (this.tripulacao.size() > 30) {
            throw new TripulacaoInvalidaException();
        }

    }

    public int getCustoDoVeiculoPorMes() {

        custoDoVeiculoPorMes = 0;

        custoDoVeiculoPorMes += this.piloto.getSalario();

        for (Militar tripulante : tripulacao) {

            custoDoVeiculoPorMes += tripulante.getSalario();

        }

        return custoDoVeiculoPorMes;
    }

    public List<Militar> getTripulacao() {

        return this.tripulacao;
    }

    public double getKmPorLitro() {

        return kmPorLitro;
    }

    public double getPrecoDoLitroDeCombustivel() {

        return precoDoLitroDeCombustivel;
    }

    public Militar getPiloto() {

        return piloto;
    }

    @Override
    public String toString() {

        return this.getClass().getSimpleName() +
                "piloto=" + piloto +
                ", kmPorLitro=" + kmPorLitro +
                ", precoDoLitroDeCombustivel=" + precoDoLitroDeCombustivel +
                ", tripulacao=" + tripulacao +
                '}';
    }

}
