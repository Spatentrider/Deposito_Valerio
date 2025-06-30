

public class ProvaFunzioni2 {

    //metodo ricorsivo
     static int fattoriale(int n){
        if(n == 1) return 1;
        return n * fattoriale((n - 1));
    }

    public static void main(String[] args) {

        //chiamata metodo
        System.out.println(fattoriale(5));

        //nessun oggetto necessario
        System.out.println(UtilitaMatematica.quadrato(5));

        //creazione oggetto e chiamata metodo
        UtilitaMatematica obj = new UtilitaMatematica();
        System.out.println(obj.cubo(5));
        
        
    }
}

   class UtilitaMatematica {
        //metodo statico
        static int quadrato(int num){
            return num * num;
        }
        //metodo non statico
        int cubo(int num){
            return num * num * num;}
    }