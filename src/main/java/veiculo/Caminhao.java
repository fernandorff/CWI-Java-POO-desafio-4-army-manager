package veiculo;

import erros.TripulacaoInvalidaException;
import militar.*;

import java.util.Collections;

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

    public void tripulacaoValida() {

        if (tripulacao.size() < 5 || tripulacao.size() > 30) {
            throw new TripulacaoInvalidaException();
        }

    }


}
