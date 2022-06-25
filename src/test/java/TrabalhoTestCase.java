import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class TrabalhoTestCase {
    @Test
    public void testCreateTrabalho() {
        Trabalho trabalho = new Trabalho("Preparação", new Matricula("55-01-LI"), "Coimbra", new Data(24,6,2022), new Data(25,6,2022));
        assertEquals("Preparação", trabalho.getTipoTrabalho());
        assertEquals(new Matricula("55-01-LI").toString(), trabalho.getMatricula().toString());
        assertEquals("Coimbra", trabalho.getOficina());
        assertEquals(new Data(24,6,2022).toString(), trabalho.getDataInicio().toString());
        assertEquals(new Data(25,6,2022).toString(), trabalho.getDataFim().toString());
    }
}
