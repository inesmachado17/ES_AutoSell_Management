import Model.Cliente;
import Model.Matricula;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ClienteTestCase {
    @Test
    public void testCreateCliente() {
        Cliente cliente = new Cliente( 230223221, "Pedro",919091910, "pedro@estg.pt", "Trv. da Fonte Nº2 - Leiria", "2400-200");
        assertEquals("Pedro", cliente.getNome());
        assertEquals(230223221, cliente.getNif());
        assertEquals(919091910, cliente.getTelefone());
        assertEquals("pedro@estg.pt", cliente.getEmail());
        assertEquals("Trv. da Fonte Nº2 - Leiria", cliente.getMorada());
        assertEquals("2400-200", cliente.getCodPostal());
    }

}
