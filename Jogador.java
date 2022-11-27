public class Jogador {
    private int     numeroJogador;
    private Carta[] cartas;
    private boolean abandonou;
    private double  quantidaApostada;

    public int getNumeroJogador() {
        return numeroJogador;
    }

    public void setNumeroJogador(int numeroJogador) {
        this.numeroJogador = numeroJogador;
    }

    public Carta[] getCartas() {
        return cartas;
    }

    public void setCartas(Carta[] cartas) {
        this.cartas = cartas;
    }

    public boolean isAbandonou() {
        return abandonou;
    }

    public void setAbandonou(boolean abandonou) {
        this.abandonou = abandonou;
    }

    public double getQuantidaApostada() {
        return quantidaApostada;
    }

    public void setQuantidaApostada(double quantidaApostada) {
        this.quantidaApostada = quantidaApostada;
    }

}

