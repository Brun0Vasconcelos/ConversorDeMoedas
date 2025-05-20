package servico;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.util.Map;

public class ArquivoServico {

    public void salvarComoJson(Map<String, Double> resultados, String moedaBase, double valorOriginal) {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();

        Cotacao cotacao = new Cotacao(moedaBase, valorOriginal, resultados);

        try {
            FileWriter writer = new FileWriter("cotacao_" + moedaBase + "_" + System.currentTimeMillis() + ".json");
            gson.toJson(cotacao, writer);
            writer.close();
            System.out.println("Cotação salva com sucesso!");
        } catch (Exception e) {
            System.out.println("Erro ao salvar o arquivo: " + e.getMessage());
        }
    }

    private static class Cotacao {
        private final String moedaBase;
        private final double valorInformado;
        private final Map<String, Double> conversoes;

        public Cotacao(String moedaBase, double valorInformado, Map<String, Double> conversoes) {
            this.moedaBase = moedaBase;
            this.valorInformado = valorInformado;
            this.conversoes = conversoes;
        }
    }
}
