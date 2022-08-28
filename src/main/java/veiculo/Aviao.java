package veiculo;

import erros.TripulacaoInvalidaException;
import militar.Elite;
import militar.EspecialistaAereo;
import militar.Militar;
import militar.PilotoAviao;

public class Aviao extends Veiculo {

    public Aviao(double kmPorLitro, double predoDoCombustivel, PilotoAviao piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Aviao(double kmPorLitro, double predoDoCombustivel, EspecialistaAereo piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    public Aviao(double kmPorLitro, double predoDoCombustivel, Elite piloto, Militar... argsTripulantes) {

        super(kmPorLitro, predoDoCombustivel, piloto, argsTripulantes);

    }

    @Override
    public void tripulacaoValida() {

        if (this.getTripulacao().size() > 1) {
            throw new TripulacaoInvalidaException();
        }

    }

}
