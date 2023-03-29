/**
 * Classe que contém o buffer a ser compartilhado entre o produto e o consumidor.
 *
 * @author osmar
 */
public class Compartilhado {

    private int buffer;
    private int tamanhoBuffer;

    public Compartilhado() {
        this(0, 25);
    }

    public Compartilhado(int buffer, int tamanhoBuffer) {
        setBuffer(buffer);
        setTamanhoBuffer(tamanhoBuffer);
    }

    public int getBuffer() {
        return buffer;
    }

    public void setBuffer(int buffer) {
        this.buffer = buffer;
    }

    public int getTamanhoBuffer() {
        return tamanhoBuffer;
    }

    public void setTamanhoBuffer(int tamanhobuffer) {
        this.tamanhoBuffer = tamanhobuffer;
    }

    /**
     * Método que consome o buffer.
     */
    public void consumir() {
        while (getBuffer() <= 0) { // Buffer vazio, esperando produção
            System.out.println("Buffer Vazio, Consumidor esperando pelo produtor");
            try {
                //Coloca a Thread em espera
                wait();
            } catch (InterruptedException e) {
            }
        }

        //Consome o buffer
        setBuffer(getBuffer() - 1);

        System.out.println("Consumidor consumindo / buffer :" + getBuffer());
        //Notifica a Thread que foi consumido
        notify();
    }

    /**
     * Método que produz o buffer.
     */
    public void produzir() {
        while (getBuffer() >= getTamanhoBuffer()) { // Buffer cheio, esperando consumir	
            System.out.println("Buffer Cheio, Produtor esperando pelo Consumidor");
            try {
                //Coloca a Thread em espera
                wait();
            } catch (InterruptedException e) {
            }
        }
        //Produz o buffer
        setBuffer(getBuffer() + 1);

        System.out.println("Produtor produzindo / buffer :" + getBuffer());
        //Notifica a Thread que foi produzido
        notify();
    }
}