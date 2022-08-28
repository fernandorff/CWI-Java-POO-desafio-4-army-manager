package erros;

public class TripulacaoInvalidaException extends RuntimeException {

    public TripulacaoInvalidaException() {

        super(  "\nA tripulacao deste veículo é invalida! Lembre-se:\n" +
                "- Aviao deve ter no máximo 1 tripulante.\n" +
                "- Caminhao deve ter no máximo 30 e no mínimo 5 tripulantes.\n" +
                "- Helicoptero deve ter no maximo 10 tripulantes.\n" +
                "- Tanque deve ter exatamente 3 tripulantes.");
    }

}
