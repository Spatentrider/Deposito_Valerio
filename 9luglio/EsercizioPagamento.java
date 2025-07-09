import java.util.List;
import java.util.ArrayList;

// Interfaccia Strategy
interface MetodoPagamento {
    void paga(double importo);
    String getNome();
}

// Strategia concreta: CartadiCredito
class CartadiCredito implements MetodoPagamento {
    
    //attributo privato nome
    String nome = "Carta di credito";
    //override metodo interfaccia
    public void paga(double importo) {
        System.out.println("Hai pagato " + importo +" tramite carta di credito");
 
    }

    //getter nome
      public String getNome() {
        return nome;
    }
}

// Strategia concreta: Paypal
class Paypal implements MetodoPagamento {

    //attributo privato nome
    String nome = "Paypal";
    //override metodo interfaccia
    public void paga(double importo) {
        System.out.println("Hai pagato " + importo +" tramite Paypal");
       
    }

    //getter nome
     public String getNome() {
        return nome;
    }
}

//classe Contect Singleton e Subject di Observer clienti
class PagamentoContext {

    //istanza privata della classe
    private static PagamentoContext instance;
    //interfaccia privata
    private MetodoPagamento metodoPagamento;
    //Lista dei clienti Observer
    private List<Clienti> clienti = new ArrayList<>();

    //costruttore privato
    private PagamentoContext() {}


     // Metodo statico per accedere all’istanza
    public static PagamentoContext getInstance() {
        if (instance == null) {
            instance = new PagamentoContext();
        }
        return instance;
    }

    //assegnazione istanza di un concreteStrategy
    public void setMetodoPagamento(MetodoPagamento metodoPagamento) {
        this.metodoPagamento = metodoPagamento;
    }

    //metodo dell'interfaccia specializzato nelle strategie concrete
    public void performTask(double importo) {
        metodoPagamento.paga(importo);
        //notifica ai clienti del pagamento
        notifyClienti(importo);
    }

    //metodo per aggiungere clienti
    public void aggiungiClienti(Clienti cliente) {
        clienti.add(cliente);
    }

    //metodo per rimuovere clienti
    public void rimuoviClienti(Clienti cliente) {
        clienti.remove(cliente);
    }

    //metodo che cicla con un for each i clienti e li notifica del pagamento
    private void notifyClienti(double importo) {
        String nomeClasse = metodoPagamento.getNome();
        for (Clienti cliente : clienti) {
            cliente.update(importo, nomeClasse);
        }
    }
}

//interfaccia dell'Observer Clienti
interface ObserverClienti {
    void update(double importo, String metodo);
}

//classe Clienti Observer del Subject MetodoPagamento
class Clienti implements ObserverClienti  {
    //attributo privato del nome
    private String nome;

    //costruttore con parametro del nome
    public Clienti(String nome) {
        this.nome = nome;
    }

    //metod di notifica dei clienti
    public void update(double importo, String metodo) {
        System.out.println(nome + " notificato: pagamento di " + importo + " con " + metodo);
    }
}
