import java.util.ArrayList;
import java.util.Scanner;

//classe camera
class Camera{
    //dichiarazione attrivuti
    protected int numero;
    protected float prezzo;
    //costruttore com parametri
    Camera(int numero, float prezzo){
        this.numero = numero;
        this.prezzo = prezzo;
    }

    //getter numero
    public int getNumero() {
        return numero;
    }

    //setter numero
    public void setNumero(int numero) {
        this.numero = numero;
    }

    //getter prezzo
    public float getPrezzo() {
        return prezzo;
    }

    //setter prezzo
    public void setPrezzo(float prezzo) {
        this.prezzo = prezzo;
    }

    //metodo stampa info
    public void dettagli() {
        System.out.println("Numero camera "+ numero + " prezzo: " + prezzo);
    }

    //Override metodo con booleano
    public void dettagli(boolean conPrezzo){
        if(conPrezzo){// se true stampa anche prezzo
            System.out.println("Numero camera "+ numero + " prezzo: " + prezzo);
        }else{// se false solo numero
            System.out.println("Numero camera "+ numero );
        }

    }


}

class Suite extends Camera{
        //dichiarazione attributi
        private String serviziextra;

        //costruttore predefinito
        Suite(int numero, float prezzo, String serviziextra){
            //uso di super per richiamare costruttore classe madre
            super(numero, prezzo);
            this.serviziextra = serviziextra;
        }

        //getter serviziExtra
        public String getServiziExtra() {
            return serviziextra;
        }

        //setter prezzo
        public void setServiziExtra(){
            this.serviziextra = serviziextra;
        }

        //cambiamento del metodo dettagli della classe madre con Override
        @Override
        public void dettagli() {
        System.out.println("Numero camera "+ this.getNumero() + " prezzo: " + this.getPrezzo() + "servizi extra: " + serviziextra);
        }    
    }

class Hotel{
        //dichiarazione attributi
        private String nome;
        private ArrayList<Camera> camere;

        //costruttore predefinito con instanziazione ArrayList
        Hotel(String nome){
            this.nome = nome;
            this.camere = new ArrayList<>();
        }

        //metodo per aggiungere camera ad ArrayList
        public void aggiungiCamera(Camera camera){
            camere.add(camera);
        }

        //getter camere
        public ArrayList<Camera> getCamere() {
            return camere;
        }

        //metodo stampa info camere
        public void mostraCamere() {
            System.out.println("Camere presenti :");
            //ciclo for each dell'ArrayList e chiamata metodo di stampa di oggetto Camera
            for (Camera camera : camere) {
                camera.dettagli();
            }
    }

        //metodo oer contare quante Suite in ArrayList camere
        public static int contaSuite(ArrayList<Camera> camere) {
            //inizializzazione contatore Suite
            int count = 0;
            //ciclo for each per scorrere ArrayList
            for (Camera camera : camere) {
                //se oggetto è Suite aumento contatore
                if (camera instanceof Suite) {
                    count++;
                }
            }
            return count;
            }
    }

public class EsercizioOverride {
    public static void main(String[] args) {

        String input = " ";
        int inputnumero = 0;

        Scanner scanner = new Scanner(System.in);
        Scanner scannernumeri = new Scanner(System.in);

        //creazione oggetto Hotel
        Hotel hotel = new Hotel("Hilton");

        //creazione oggetti Camera
        Camera camera1 = new Camera(101, 80.5f);
        Camera camera2 = new Camera(102, 75.0f);

        //creazione oggetti Suite
        Suite suite1 = new Suite(201, 150.0f, "Jacuzzi");
        Suite suite2 = new Suite(202, 180.0f, "Spa");

        //chiamate metodo per aggiungere Camera e Suite all'ArrayList di Hotel
        hotel.aggiungiCamera(camera1);
        hotel.aggiungiCamera(camera2);
        hotel.aggiungiCamera(suite1);
        hotel.aggiungiCamera(suite2);

        //chiamata metodo per stampare tutte camere
        hotel.mostraCamere();

        // Stampa info camere
        camera1.dettagli();             // metodo base
        camera2.dettagli(false);        // overload
        suite1.dettagli();             // override
        suite2.dettagli(true);         // overload della classe base


        //Chiamata metodo statico per contare le suite
        int numeroSuite = Hotel.contaSuite(hotel.getCamere());
        System.out.println("Suite nell\' hotel: " + numeroSuite);

        do {
            System.out.println("Inserisci 1 per camera o 2 per suite");

            inputnumero = scannernumeri.nextInt();
            switch (inputnumero) {
                case 1:
                    System.out.println("Numero camera");
                    int numero = scannernumeri.nextInt();
                    System.out.println("Prezzo: ");
                    float prezzo = scannernumeri.nextFloat();
                    hotel.aggiungiCamera(new Camera(numero, prezzo));
                    System.out.println("camera aggiunta");
                    break;
                case 2:
                    System.out.println("Numero Suite");
                    int numero2 = scannernumeri.nextInt();
                    System.out.println("Prezzo: ");
                    float prezzo2 = scannernumeri.nextFloat();
                    System.out.println("Servizi extra ");
                    String serviziextra = scanner.nextLine();
                    hotel.aggiungiCamera(new Suite(numero2, prezzo2, serviziextra));
                    System.out.println("Suite aggiunta");
                    break;
                default:
                    System.out.println("Comando non valido");
                    break;
                
            
            }
            System.out.println("Vuoi continuare? \"si\" o \"no\"");
            input = scanner.nextLine();
        } while (!input.equals("no"));
        hotel.mostraCamere();
    }
}
