import Model.Peca;
import Model.Pedido;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PedidoTestCase {
    @Test
    public void testCreatePedido() {
        Pedido pedido = new Pedido("Lisboa", "Leiria", 4);
        assertEquals("Lisboa", pedido.getOrigem());
        assertEquals("Leiria", pedido.getDestino());
        assertEquals(4, pedido.getQuantidade());
    }
}
