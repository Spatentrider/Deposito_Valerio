import java.util.ArrayList;

class Camera{
    private int numero;
    private float prezzo;
    Camera(int numero, float prezzo){
        this.numero = numero;
        this.prezzo = prezzo;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero() {
        this.numero = numero;
    }

    public float getPrezzo() {
        return prezzo;
    }

    public void setPrezzo() {
        this.prezzo = prezzo;
    }

    public void dettagli() {
        System.out.println("Numero camera "+ numero + " prezzo: " + prezzo);
    }

    public void dettagli(boolean conPrezzo){
        if(conPrezzo){
            System.out.println("Numero camera "+ numero + " prezzo: " + prezzo);
        }else{
            System.out.println("Numero camera "+ numero );
        }

    }

class Suite extends Camera{
        private String serviziextra;

        Suite(int numero, float prezzo, String serviziextra){
            super(numero, prezzo);
            this.serviziextra = serviziextra;
        }

        public String getServiziExtra() {
            return serviziextra;
        }

        public void setServiziExtra(){
            this.serviziextra = serviziextra;
        }

        public void dettagli() {
        System.out.println("Numero camera "+ numero + " prezzo: " + prezzo + "servizi extra: " +serviziextra);
        }    
    }

 class Hotel{
        private String nome;
        private ArrayList<Camera> camere;

        Hotel(String nome, ArrayList<Camera> camere){
            this.nome = nome;
            this.camere = new ArrayList<>();
        }

        public void aggiungiCamera(Camera camera){
            camere.add(camera);
        }

        //public static int contaSuite(ArrayList<Camera> camere){

        //}
   
    }
    
    





}

public class EsercizioOverride {
    public static void main(String[] args) {
        System.out.println("sddsds");
    }
    
}
