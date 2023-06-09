package br.com.softplan.report.application;

import java.util.List;
import java.util.stream.Collectors;

public class GeradorObservacao {

    private static final String NOTA_SIMPLES_REMESSA = "Fatura da nota fiscal de simples remessa: ";
    private static final String NOTAS_SIMPLES_REMESSA = "Fatura das notas fiscais de simples remessa: ";

    /**
     * Gera uma observação com base nos números das notas fiscais fornecidos.
     * @param numerosNotasFiscais Lista de números das notas fiscais.
     * @return Observação gerada.
     */
    public String geraObservacao(List<Integer> numerosNotasFiscais) {
        if (numerosNotasFiscais.isEmpty()) {
            return "";
        }

        // Determina o texto da observação com base na quantidade de notas fiscais
        String textoObservacao = (numerosNotasFiscais.size() >= 2) ? NOTAS_SIMPLES_REMESSA : NOTA_SIMPLES_REMESSA;

        // Gera os códigos das notas fiscais separados por vírgula
        String codigosNotasFiscais = numerosNotasFiscais.stream()
                .map(String::valueOf)
                .collect(Collectors.joining(", "));

        // Adiciona o separador "e" entre os últimos códigos de notas fiscais, se houver mais de uma
        if (numerosNotasFiscais.size() > 1) {
            int lastIndex = codigosNotasFiscais.lastIndexOf(", ");
            codigosNotasFiscais = codigosNotasFiscais.substring(0, lastIndex) + " e" + codigosNotasFiscais.substring(lastIndex + 1);
        }

        // Retorna a observação completa com o texto e os códigos das notas fiscais
        return textoObservacao + codigosNotasFiscais + ".";
    }
}






