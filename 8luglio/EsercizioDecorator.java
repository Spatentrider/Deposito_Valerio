//interfaccia comune a classe da decorare e decoratore astratto
interface Messaggio{
    String getContenuto();
}
//classe da decorare
class ImplementaMessaggio implements Messaggio{
    public String getContenuto(){
        String messaggio = "prova messaggio";
        System.out.println(messaggio);
        return messaggio;
    }
}
//classe astratta del decoratore
abstract class DecoratoreMaiuscolo implements Messaggio{
    //incapsulamento interfaccia
    protected Messaggio messaggio;

    //costruttore con parametro Messaggio
    public DecoratoreMaiuscolo(Messaggio messaggio){
        this.messaggio = messaggio;
    }

    //metodo che richiama interfaccia
    public String getContenuto(){
        return messaggio.getContenuto();
    }

}
//classe concreta che estende Decoratore astratto
class ConcreteDecoratoreMaiuscolo extends DecoratoreMaiuscolo{
    //costruttore con super
    public ConcreteDecoratoreMaiuscolo(Messaggio messaggio){
        super(messaggio);
    }

    //metodo con funzionalità aggiuntiva
    public String getContenuto(){
        return super.getContenuto().toUpperCase();
    }

}