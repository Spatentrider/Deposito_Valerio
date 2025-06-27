public class ProvaFunzioni {
     //esempio funzione senza parametri
    static void saluta(){
        System.out.println("Ciao, Java!");
    }

    //esempio funzione con parametri
    static int somma(int a, int b){
        return a + b;
    }

    //esempio overloading metodi
    //funzione con parametro int
    static void mostra(int numero){
        System.out.println("Numero: " + 10 + numero);
    }

    //overloading con parametro String
    static void mostra(String testo){
        System.out.println("Testo: " + testo);
    }
    


        
    public static void main(String[] args) {
        //prova funzione
        //returnType nomeMetodo(parametri){
        // Corpo del metodo
        //return valore;} (se returnTypr non è void)

        //chiamata metodo
        saluta(); 
        
        //chiamata metodo con parametri e stampa
        System.out.println(somma(10, 20));

        //chiamata metodo con parametro int
        mostra(10);
        //chiamata metodo con parametro String
        mostra("Ciao");
    }
}
