import Model.Matricula;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class MatriculaTestCase {
    @Test
    public void testCreateMatricula() {
        Matricula matricula = new Matricula("55-01-LI");
        assertEquals("55-01-LI", matricula.getMatricula());
    }

}
