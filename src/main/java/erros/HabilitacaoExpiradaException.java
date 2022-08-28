package erros;

public class HabilitacaoExpiradaException extends RuntimeException {

    public HabilitacaoExpiradaException() {

        super("\nA habilitação de algum piloto não tem validade suficiente para completar a missao.");
    }

}
