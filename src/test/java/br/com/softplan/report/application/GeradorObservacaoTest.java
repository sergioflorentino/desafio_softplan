package br.com.softplan.report.application;

import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class GeradorObservacaoTest {

    private GeradorObservacao geradorObservacao;
    private static final String NOTA_SIMPLES_REMESSA = "Fatura da nota fiscal de simples remessa: ";
    private static final String NOTAS_SIMPLES_REMESSA = "Fatura das notas fiscais de simples remessa: ";

    @Before
    public void setUp() {
        geradorObservacao = new GeradorObservacao();
    }

    @Test
    public void deve_GerarObservacao_SemNota() {
        //Dado
        List<Integer> numerosNotaFiscal = Collections.emptyList();

        //Quando
        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        //Entao
        assertEquals("", observacao);
    }

    @Test
    public void deve_GerarObservacao_Com_Uma_Nota() {
        List<Integer> numerosNotaFiscal = Collections.singletonList(1);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals(NOTA_SIMPLES_REMESSA + "1.", observacao);
    }

    @Test
    public void deve_GerarObservacao_Com_Duas_Notas() {
        List<Integer> numerosNotaFiscal = Arrays.asList(1, 3);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals(NOTAS_SIMPLES_REMESSA+  "1 e 3.", observacao);
    }

    @Test
    public void deve_GerarObservacao_Com_Diversas_Notas() {
        List<Integer> numerosNotaFiscal = Arrays.asList(1, 2, 3, 4, 5);

        String observacao = geradorObservacao.geraObservacao(numerosNotaFiscal);

        assertEquals(NOTAS_SIMPLES_REMESSA+ "1, 2, 3, 4 e 5.", observacao);
    }

}
