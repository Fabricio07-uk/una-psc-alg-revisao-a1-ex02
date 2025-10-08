import java.util.Scanner;
import java.util.InputMismatchException;

public class SimuladorSonic3 {

   
    private static int obterNumero(Scanner scanner, String prompt, int min, int max) {
        int numero = -1;
        while (true) {
            try {
                System.out.print(prompt);
                numero = scanner.nextInt();
                if (numero >= min && numero <= max) {
                    break; // Sai do loop se o número for válido
                } else {
                    System.out.println("-> Erro: O valor deve estar entre " + min + " e " + max + ". Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("-> Erro: Entrada inválida. Por favor, digite um número inteiro.");
                scanner.next(); // Limpa o buffer do scanner
            }
        }
        return numero;
    }

    public static void main(String[] args) {
        // Usando try-with-resources para garantir que o Scanner seja fechado
        try (Scanner scanner = new Scanner(System.in)) {

            // --- Inicialização das Emoções ---
            // Emoções Positivas
            int esperanca = 0;
            int confianca = 0;
            int determinacao = 0;

            // Emoções Negativas
            int medo = 0;
            int desanimo = 0;
            int incerteza = 0;

            System.out.println("--- SIMULADOR DE BATALHA EMOCIONAL: SONIC 3 ---");
            System.out.println("Analise os eventos e veja o resultado do confronto contra Shadow!\n");

            // --- Seção 1: Novos Aliados ---
            System.out.println("--- 1. Novos Aliados ---");
            int novosAliados = obterNumero(scanner, "Quantos novos aliados a equipe encontrou? ", 0, Integer.MAX_VALUE);

            if (novosAliados > 0) {
                esperanca = novosAliados * 15;
            } else {
                medo = 40;
            }

            // --- Seção 2: Desafio de Poder ---
            System.out.println("\n--- 2. Desafio de Poder ---");
            System.out.println("Avalie o desempenho da equipe nos 3 confrontos iniciais (0 a 10):");
            int pontuacaoDesafio1 = obterNumero(scanner, "Pontuação do Desafio 1: ", 0, 10);
            int pontuacaoDesafio2 = obterNumero(scanner, "Pontuação do Desafio 2: ", 0, 10);
            int pontuacaoDesafio3 = obterNumero(scanner, "Pontuação do Desafio 3: ", 0, 10);

            double mediaDesafios = (pontuacaoDesafio1 + pontuacaoDesafio2 + pontuacaoDesafio3) / 3.0;

            if (mediaDesafios >= 7) {
                confianca = 60;
            } else {
                desanimo = 60;
            }
            
            // --- Seção 3: Busca por Soluções ---
            System.out.println("\n--- 3. Busca por Soluções ---");
            final int TOTAL_ESTRATEGIAS = 12;
            int estrategiasAnalisadas = obterNumero(scanner, "Das " + TOTAL_ESTRATEGIAS + " estratégias, quantas foram analisadas completamente? ", 0, TOTAL_ESTRATEGIAS);

            determinacao = estrategiasAnalisadas * 10;
            
            int estrategiasNaoAnalisadas = TOTAL_ESTRATEGIAS - estrategiasAnalisadas;
            incerteza = estrategiasNaoAnalisadas * 10;

            // --- Resultados Finais ---
            System.out.println("\n-------------------------------------------");
            System.out.println("        ANÁLISE EMOCIONAL DA EQUIPE        ");
            System.out.println("-------------------------------------------");
            
            // Pontuações
            System.out.println("Esperança: " + esperanca + " pts / Medo: " + medo + " pts");
            System.out.println("Confiança: " + confianca + " pts / Desânimo: " + desanimo + " pts");
            System.out.println("Determinação: " + determinacao + " pts / Incerteza: " + incerteza + " pts");
            
            // Cálculo dos Totais
            int totalPositivo = esperanca + confianca + determinacao;
            int totalNegativo = medo + desanimo + incerteza;

            System.out.println("\nSOMA DAS EMOÇÕES POSITIVAS: " + totalPositivo + " pts");
            System.out.println("SOMA DAS EMOÇÕES NEGATIVAS: " + totalNegativo + " pts");
            System.out.println("-------------------------------------------");

            // Determinação do Vencedor
            System.out.println("\n--- RESULTADO DO CONFRONTO ---");
            if (totalPositivo > totalNegativo) {
                System.out.println("O Shadow foi derrotado.");
            } else {
                System.out.println("O Shadow venceu o time do Sonic.");
            }
             System.out.println("-------------------------------------------");
        }
    }
}