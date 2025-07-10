public class ProvaArray {
    public static void main(String[] args) {
        //dichiarazione e inizializzazione array
        int[] numeri = new int[5];
        //Array di dimensione 5

        //Inizializzazione diretta
        int[] valori = {1, 2, 3, 4, 5};

        System.out.println(("Primo numero:" + valori[0] ));

        //Dichiarazione di un array di 5 elementi
        int[] numeri2 = new int[5];

        //Riempimento array con numeri 1-5
        for(int i = 0; i < numeri2.length; i++){
            numeri2[i] = i + 1;
        }

        //Stampa elementi dell'array
        System.out.println("Elementi dell'array:");
        for(int i = 0; i < numeri2.length; i ++){
            System.out.println(numeri2[i] + " ");
        }

        //Array 2d
        int[][] matrice = new int[3][3];

        //inizializzazione diretta
        int[][] matricePredefinita = {
            {1, 2, 3},
            {4, 5, 6},
            {7, 8, 9}
        };

        //stampa valore matrice 
        System.out.println(matricePredefinita[1][2]);

        //dichiarazione matrice 3x3
        int[][] matrice2 = new int[3][3];
        
        int valore = 1;

        //Riempimento della matrice con numeri progressivi
        for(int i = 0; i < matrice2.length; i++){
            for(int j = 0; j < matrice2[i].length; j++){
                matrice2[i][j] = valore++;
            }
        }

        //Stampa della matrice
        System.out.println("Matrice 3x3:");
        for(int i = 0; i < matrice2.length; i++) {
            for(int j = 0; j < matrice2[i].length; j++) {
                System.out.println(matrice2[i][j] + "\t");;
            }
             System.out.println();
        }
        
    }
}
