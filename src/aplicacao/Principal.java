package aplicacao;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import servico.ConversorServico;
import servico.ArquivoServico;

public class Principal {
    public static void main(String[] args) {
        System.out.println("Seja Bem-Vindo ao conversor de moedas");
        Scanner teclado = new Scanner(System.in);
        ConversorServico servico = new ConversorServico();
        ArquivoServico arquivo = new ArquivoServico();

        Map<String, String> moedas = new HashMap<>();
        moedas.put("1", "Real (BRL)");
        moedas.put("2", "Peso argentino (ARS)");
        moedas.put("3", "Dólar canadense (CAD)");
        moedas.put("4", "Dólar americano (USD)");
        moedas.put("5", "Euro (EUR)");
        moedas.put("6", "Libra esterlina (GBP)");

        while (true) {
            System.out.println("Escolha uma moeda base:\n" +
                    "1) Real (BRL)\n" +
                    "2) Peso argentino (ARS)\n" +
                    "3) Dólar canadense (CAD)\n" +
                    "4) Dólar americano (USD)\n" +
                    "5) Euro (EUR)\n" +
                    "6) Libra esterlina (GBP)\n" +
                    "7) Sair\n" +
                    "Digite a opção desejada:\n");
            String opcao = teclado.nextLine();

            if (opcao.equals("7")) {
                System.out.println("Encerrando o programa...");
                break;
            }

            if (!moedas.containsKey(opcao)) {
                System.out.println("Opção inválida! Tente novamente.");
                continue;
            }

            String moedaBase = moedas.get(opcao);
            System.out.println("Moeda base selecionada: " + moedaBase);

            System.out.println("Digite o valor a ser convertido ou digite 'voltar' para escolher outra moeda");
            String entradaValor = teclado.nextLine();
            if (entradaValor.equalsIgnoreCase("voltar")) {
                continue;
            }
            double valor = 0;
            try {
                valor = Double.parseDouble(entradaValor);
            } catch (NumberFormatException e) {
                System.out.println("Valor inválido! Digite um número válido.");
                continue;
            }
            int inicio = moedaBase.indexOf("(") + 1;
            int fim = moedaBase.indexOf(")");
            String codigoMoeda = moedaBase.substring(inicio, fim);

            Map<String, Double> resultados = servico.converter(codigoMoeda, valor);
            System.out.println("Deseja salvar essa conversão? s/n");
            String resposta = teclado.nextLine();

            if (resposta.equalsIgnoreCase("s")) {
                arquivo.salvarComoJson(resultados, codigoMoeda, valor);
            }
        }
    }
}

