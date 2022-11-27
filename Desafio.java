import java.util.Scanner;

public class Desafio {

    public static void main(String[] args) {
        try {
            poker();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void poker() throws Exception {
        Scanner s = new Scanner(System.in);

        System.out.print("Quantos jogadores possui na mesa: ");
        int qtdeJogadores = s.nextInt();

        if (qtdeJogadores <= 0) {
            lancarException();
        }

        Baralho baralho = new Baralho();
        baralho.embaralhar();
        double montante = 0;


        Jogador[] jogadores =  new Jogador[qtdeJogadores];

        for (int i = 0; i < qtdeJogadores; i++) {
            jogadores[i].setNumeroJogador(i);
            jogadores[i].setCartas(baralho.darCartas());
        }

        boolean continuaPerguntando = true;

        while (continuaPerguntando) {
            perguntaParaJogadorSeQuerAbandonar(s, qtdeJogadores, jogadores);

            imprimiCartasJogadoresRestantes(qtdeJogadores, jogadores);

            montante = perguntaQuantiaApostada(s, montante, qtdeJogadores, jogadores);

            continuaPerguntando = continuaAsPerguntas(qtdeJogadores, jogadores, continuaPerguntando);
        }

        baralho.imprimiCincoCartas();
        System.out.print("Qual jogador ganhou: ");
        int ganhador = s.nextInt();

        System.out.print("Ganhador foi: " + jogadores[ganhador].getNumeroJogador());
        System.out.println("Ganhou R$ " + montante);
    }

    private static void lancarException() throws Exception {
        throw new Exception("O número de jogadores tem que ser maior que 0");
    }

    private static boolean continuaAsPerguntas(int qtdeJogadores, Jogador[] jogadores, boolean continuaPerguntando) {
        for (int i = 0; i < qtdeJogadores; i++) {
            continuaPerguntando = false;
            if (jogadores[0].getQuantidaApostada() == jogadores[i].getQuantidaApostada()) {
                continuaPerguntando = true;
            }
        }
        return continuaPerguntando;
    }

    private static double perguntaQuantiaApostada(Scanner s, double montante, int qtdeJogadores, Jogador[] jogadores) {
        for (int i = 0; i < qtdeJogadores; i++) {
            if (!jogadores[i].isAbandonou()) {
                System.out.print("Qual quantia o jogador" + jogadores[i].getNumeroJogador() + " vai apostar: ");
                double quantia = s.nextDouble();
                montante += quantia;
                jogadores[i].setQuantidaApostada(quantia);
            }
        }
        return montante;
    }

    private static void imprimiCartasJogadoresRestantes(int qtdeJogadores, Jogador[] jogadores) {
        for (int i = 0; i < qtdeJogadores; i++) {
            if (!jogadores[i].isAbandonou()) {
                for (int j = 0; j < jogadores[i].getCartas().length; j++) {
                    System.out.println(jogadores[i].getCartas()[j].getNome() + jogadores[i].getCartas()[j].getNaipe());
                }
            }
        }
    }

    private static void perguntaParaJogadorSeQuerAbandonar(Scanner s, int qtdeJogadores, Jogador[] jogadores) {
        for (int i = 0; i < qtdeJogadores; i++) {
            System.out.print("Quer abandonar a mão ou apostar?");
            String resposta = s.next();
            jogadores[i].setAbandonou(resposta.equalsIgnoreCase("abandonar"));
        }
    }
}



