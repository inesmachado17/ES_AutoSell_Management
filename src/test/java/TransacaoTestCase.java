import Model.Data;
import Model.Matricula;
import Model.Transacao;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TransacaoTestCase {
    @Test
    public void testCreateTransacao() {
        Transacao transacao = new Transacao(
                "Venda",
                201872112,
                600026027,
                new Matricula("55-01-LI"),
                900.00,
                new Data(04, 06, 2022)
        );
        assertEquals("Venda", transacao.getTipo());
        assertEquals(201872112, transacao.getNifComprador());
        assertEquals(600026027, transacao.getNifVendedor());
        assertEquals("55-01-LI", transacao.getMatricula().getMatricula());
        assertEquals(900.00, transacao.getValor());
        assertEquals("4/6/2022", transacao.getDataTransacao().toString());
    }
}
