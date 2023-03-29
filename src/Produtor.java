/**
 * Classe produtora.
 * 
 * @author osmar
 */
public class Produtor implements Runnable {

    private Compartilhado x;
    private int tempo;

    public Produtor(Compartilhado x) {
        this.x = x;
    }

    public int getTempo() {
        return tempo;
    }

    public void setTempo(int tempo) {
        this.tempo = tempo;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Gera um atraso aleatório com base no tempo
                Thread.sleep((int) (Math.random() * getTempo()));
            } catch (InterruptedException e) {
            }
            x.produzir();
        }
    }
}