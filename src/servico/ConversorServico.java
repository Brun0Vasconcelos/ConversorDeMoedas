package servico;

import com.google.gson.Gson;
import modelo.Conversao;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;

public class ConversorServico {

    public Map<String, Double> converter(String moedaBase, double valor) {
        String[] moedasDestino = {"BRL", "ARS", "CAD", "USD", "EUR", "GBP"};
        Map<String, Double> resultados = new HashMap<>();

        for (String moedaDestino : moedasDestino) {
            if (moedaDestino.equals(moedaBase)) {
                continue;
            }

            try {
                String apiKey = "a920a5f02618e0ac89012710";
                String enderecoURL = "https://v6.exchangerate-api.com/v6/" + apiKey +
                        "/pair/" + moedaBase + "/" + moedaDestino + "/" + valor;

                URL url = new URL(enderecoURL);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();
                conexao.setRequestMethod("GET");

                if (conexao.getResponseCode() != 200) {
                    System.out.println("Erro na conexão: código " + conexao.getResponseCode());
                    continue;
                }

                BufferedReader leitor = new BufferedReader(new InputStreamReader(conexao.getInputStream()));
                StringBuilder json = new StringBuilder();
                String linha;

                while ((linha = leitor.readLine()) != null) {
                    json.append(linha);
                }

                leitor.close();

                Gson gson = new Gson();
                Conversao conversao = gson.fromJson(json.toString(), Conversao.class);

                double resultado = conversao.getConversion_result();
                resultados.put(moedaDestino, resultado);

                System.out.println(valor + " " + moedaBase + " equivalem a " +
                        conversao.getConversion_result() + " " + moedaDestino);

            } catch (Exception e) {
                System.out.println("Erro durante a requisição para " + moedaDestino + ": " + e.getMessage());
            }
        }
        return resultados;
    }
}
