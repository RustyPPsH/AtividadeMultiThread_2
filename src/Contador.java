public class Contador implements Runnable {

    private static int i = 0;
    private String nome;

    public Contador(String nome) {
        this.nome = nome;
    }

    private void conta() {
        i = i + 1;
        System.out.println("Contador e: " + i + ", atualizado por: " + nome);
    }

    public void run() {
        for (int i = 0; i < 10; i++) {
            conta();
        }
    }
}