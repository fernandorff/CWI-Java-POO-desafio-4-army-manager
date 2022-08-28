import militar.PilotoCaminhao;
import org.junit.Test;

import java.time.LocalDate;

public class VeiculoTest {

    PilotoCaminhao piloto = new PilotoCaminhao(3000, LocalDate.now().plusDays(20));

    @Test
    public void testeConstrutor() {

        System.out.println(piloto);

    }

}
