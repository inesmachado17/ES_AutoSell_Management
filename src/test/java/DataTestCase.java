import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class DataTestCase {
    @Test
    public void testCreateData() {
        Data data = new Data(25,6,2022);
        assertEquals("25/6/2022", data.toString());
    }
}
