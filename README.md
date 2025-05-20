# 💱 Conversor de Moedas

Aplicação Java em modo console que permite converter valores entre moedas internacionais usando a API [ExchangeRate](https://www.exchangerate-api.com/).

O usuário informa uma moeda base e um valor, e o programa retorna a conversão para as demais moedas disponíveis. Opcionalmente, é possível salvar o resultado em um arquivo `.json`.

---

## 🚀 Funcionalidades

- Menu interativo com 6 moedas
- Conversão de valor com base em cotações reais
- Validação de entradas
- Opção de voltar para o menu a qualquer momento
- Exibição dos resultados no console
- Geração de arquivo `.json` com os dados da conversão
- Arquivo formatado com `Gson` (`setPrettyPrinting()`)

---

## 💵 Moedas disponíveis

| Código | Nome                |
|--------|---------------------|
| BRL    | Real                |
| USD    | Dólar americano     |
| EUR    | Euro                |
| GBP    | Libra esterlina     |
| ARS    | Peso argentino      |
| CAD    | Dólar canadense     |

---

## 🧱 Estrutura do projeto
```
src/
├── aplicacao/
│ └── Principal.java # Interface com o usuário
├── modelo/
│ └── Conversao.java # Representa a resposta da API
├── servico/
│ ├── ConversorServico.java # Faz a conversão via API
│ └── ArquivoServico.java # Salva os resultados em .json
```

---

## 📦 Exemplo de saída JSON salva

```json
{
  "moedaBase": "EUR",
  "valorInformado": 100.0,
  "conversoes": {
    "ARS": 127436.33,
    "GBP": 84.12,
    "CAD": 156.79,
    "USD": 112.35,
    "BRL": 638.06
  }
}
```
## ⚙️ Como executar
Clone este repositório:

git clone https://github.com/Brun0Vasconcelos/ConversorDeMoedas.git

Abra o projeto no IntelliJ IDEA (ou outra IDE)

Execute a classe Principal.java

## 🔧 Requisitos
JDK 17+

Biblioteca Gson adicionada ao classpath

## 👤 Autor
Bruno Vasconcelos
📫 [linkedin.com/in/brunovasconcelos](https://www.linkedin.com/in/bruno-o-vasconcelos/)

