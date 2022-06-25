import Model.*;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
public class VeiculoTestCase {
    @Test
    public void testCreateVeiculo() {
        Veiculo veiculo = new Veiculo(new Matricula("55-01-LI"), "Corsa", "Opel", 201872112, "5P Azul Escuro");
        assertEquals("55-01-LI", veiculo.getMatricula().getMatricula());
        assertEquals("Corsa", veiculo.getModelo());
        assertEquals("Opel", veiculo.getMarca());
        assertEquals(201872112, veiculo.getDonoAnterior());
        assertEquals("5P Azul Escuro", veiculo.getCaracteristicas());
    }
}
