package veiculo;

import erros.TripulacaoInvalidaException;
import militar.Elite;
import militar.EspecialistaTerrestre;
import militar.Militar;
import militar.PilotoTanque;

public class Tanque extends Veiculo {

    public Tanque(double kmPorLitro, double predoDoCombustivel, PilotoTanque piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Tanque(double kmPorLitro, double predoDoCombustivel, EspecialistaTerrestre piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Tanque(double kmPorLitro, double predoDoCombustivel, Elite piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public void tripulacaoValida() {

        if (!(this.tripulacao.size() == 3)) {
            throw new TripulacaoInvalidaException();
        }

    }




}
