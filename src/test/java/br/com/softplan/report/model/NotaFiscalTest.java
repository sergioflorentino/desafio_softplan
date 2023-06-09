package br.com.softplan.report.model;

import java.math.BigDecimal;
import org.junit.Test;
import br.com.softplan.report.model.NotaFiscal;
import static org.junit.Assert.assertEquals;

public class NotaFiscalTest {

    @Test
    public void testGetNumero() {
        Long numero = 12345L;
        BigDecimal valor = BigDecimal.valueOf(100.0);
        NotaFiscal notaFiscal = new NotaFiscal(numero, valor);

        assertEquals(numero, notaFiscal.getNumero());
    }

    @Test
    public void testGetValor() {
        Long numero = 12345L;
        BigDecimal valor = BigDecimal.valueOf(100.0);
        NotaFiscal notaFiscal = new NotaFiscal(numero, valor);

        assertEquals(valor, notaFiscal.getValor());
    }
}

