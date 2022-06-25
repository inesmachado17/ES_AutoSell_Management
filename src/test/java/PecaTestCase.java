import Model.Peca;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PecaTestCase {
    @Test
    public void testCreatePeca() {
        Peca peca = new Peca("0001", "Bosh", "Lisboa", 1, "Oleo para motor");
        assertEquals("0001", peca.getReferencia());
        assertEquals("Bosh", peca.getMarca());
        assertEquals("Lisboa", peca.getLocal());
        assertEquals(1, peca.getQuantidade());
        assertEquals("Oleo para motor", peca.getDesingnacao());
    }
}
