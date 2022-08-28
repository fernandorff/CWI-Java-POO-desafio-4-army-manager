package veiculo;

import erros.TripulacaoInvalidaException;
import militar.Elite;
import militar.EspecialistaTerrestre;
import militar.Militar;
import militar.PilotoCaminhao;

public class Caminhao extends Veiculo {

    public Caminhao(double kmPorLitro, double predoDoCombustivel, PilotoCaminhao piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Caminhao(double kmPorLitro, double predoDoCombustivel, EspecialistaTerrestre piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Caminhao(double kmPorLitro, double predoDoCombustivel, Elite piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    @Override
    public void tripulacaoValida() {

        if (this.getTripulacao().size() < 5 || this.getTripulacao().size() > 30) {
            throw new TripulacaoInvalidaException();
        }

    }

}
