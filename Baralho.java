import java.util.Random;
public class Baralho {
    Carta[] baralho = new Carta[52];
    int quantidadeDeCartas = 51;

    public Baralho() {
        super();
        incializarBaralhoPorNaipe(0,  "♣");
        incializarBaralhoPorNaipe(13, "♠");
        incializarBaralhoPorNaipe(26, "♥");
        incializarBaralhoPorNaipe(39, "♦");
    }

    private void incializarBaralhoPorNaipe(int comeco, String naipe) {
        for (int i = 0; i <= 12; i++, comeco++) {
            int numero = i + 1;
            Carta carta = new Carta();
            if (numero == 1) {
                carta.setNome("A");
            } else if (numero == 11) {
                carta.setNome("J");
            } else if (numero == 12) {
                carta.setNome("Q");
            }else if (numero == 13) {
                carta.setNome("K");
            } else {
                carta.setNome(String.valueOf(numero));
            }
            carta.setNaipe(naipe);
            baralho[comeco] = carta;
        }
    }

    public void embaralhar() {
        Random random = new Random();
        for (int i = 0; i < quantidadeDeCartas; i++ ) {

            int numero = random.nextInt(1,13);
            int numeroNaipe  = random.nextInt(1,4);
            String naipe;

            if (numeroNaipe == 1) {
                naipe = "♣";
            } else if (numeroNaipe == 2) {
                naipe = "♠";
            } else if (numeroNaipe == 3) {
                naipe = "♥";
            } else {
                naipe = "♦";
            }

            if (numero == 1) {
                baralho[i].setNome("A");
            } else if (i == 11) {
                baralho[i].setNome("J");
            } else if (i == 12) {
                baralho[i].setNome("Q");
            }else if (i == 13) {
                baralho[i].setNome("K");
            } else {
                baralho[i].setNome(String.valueOf(numero));
            }

            baralho[i].setNaipe(naipe);
        }
    }

    public Carta[] darCartas() {
        Carta[] cartas = new Carta[2];

        for (int i = 0; i < 2; i++) {
            if (temCarta()) {
                cartas[i] = baralho[quantidadeDeCartas];
            }
            quantidadeDeCartas--;
        }

        return cartas;
    }

    public boolean temCarta() {
        return quantidadeDeCartas > 0;
    }

    public void imprimiBaralho() {
        for (int i = 0; i < baralho.length; i++) {
            System.out.println(baralho[i].getNome() + baralho[i].getNaipe());
        }
    }

    public void imprimiCincoCartas() {
        for (int i = 0; i < 5; i++) {
            if (temCarta()) {
                System.out.println(baralho[i].getNome() + baralho[i].getNaipe());
                quantidadeDeCartas--;
            }
        }
    }

}


