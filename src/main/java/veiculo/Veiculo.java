package veiculo;


import militar.Militar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Veiculo {

    private final List<Militar> tripulacao = new ArrayList<>();

    private final Militar piloto;

    private final double kmPorLitro;

    private final double precoDoLitroDeCombustivel;


    public Veiculo(double kmPorLitro, double precoDoLitroDeCombustivel, Militar piloto, Militar... argsTripulantes) {

        this.kmPorLitro = kmPorLitro;
        this.precoDoLitroDeCombustivel = precoDoLitroDeCombustivel;
        this.piloto = piloto;
        Collections.addAll(tripulacao, argsTripulantes);

    }

    public void tripulacaoValida() {
        // metodo vazio para aplicacao de polimorfismo

    }

    public int getCustoDosSalariosDaTripulacaoDoVeiculoPorMes() {

        int custoDoVeiculoPorMes = 0;

        custoDoVeiculoPorMes += this.piloto.getSalario();

        for (Militar tripulante : tripulacao) {

            custoDoVeiculoPorMes += tripulante.getSalario();

        }

        return custoDoVeiculoPorMes;
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

    public List<Militar> getTripulacao() {

        return tripulacao;
    }

}
