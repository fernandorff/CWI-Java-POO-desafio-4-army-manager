package veiculo;

import erros.TripulacaoInvalidaException;
import militar.Elite;
import militar.EspecialistaAereo;
import militar.Militar;
import militar.PilotoHelicoptero;

public class Helicoptero extends Veiculo {

    public Helicoptero(double kmPorLitro, double predoDoCombustivel, PilotoHelicoptero piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Helicoptero(double kmPorLitro, double predoDoCombustivel, EspecialistaAereo piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Helicoptero(double kmPorLitro, double predoDoCombustivel, Elite piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public void tripulacaoValida() {

        if (tripulacao.size() > 10) {
            throw new TripulacaoInvalidaException();
        }

    }

}
