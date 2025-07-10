
//classe stampa bios
class Bios {
    public void inizializza() {
        System.out.println("BIOS: Inizializzazione hardware completata.");
    }
}
//classe stampa HardDisk
class HardDisk {
    public void carica() {
        System.out.println("HardDisk caricato.");
    }
}
//classe stampa sistema operativo Singleton
class SistemaOperativo {
    //istanza statica privata
    private static SistemaOperativo instance;

    //costruttore privato
    private SistemaOperativo() {}

    //metodo per tornare istanza singolo
    public static SistemaOperativo getInstance() {
        if (instance == null) {
            instance = new SistemaOperativo();
        }
        return instance;
    }
    //metodo stampa
    public void avvia() {
        System.out.println("Sistema Operativo: Avvio in corso...");
    }
}
//interfaccia per lo strategy
interface AvvioStrategy {
    void avvia(Bios bios, HardDisk hd, SistemaOperativo os);
}
//strategy per avvio con tutti imetodi di stampa
class AvvioNormale implements AvvioStrategy {
    @Override
    public void avvia(Bios bios, HardDisk hd, SistemaOperativo os) {
        bios.inizializza();
        hd.carica();
        os.avvia();
    }
}

//strategy per avvio rapido con uno in meno    
class AvvioRapido implements AvvioStrategy {
    @Override
    public void avvia(Bios bios, HardDisk hd, SistemaOperativo os) {
        System.out.println("Avvio rapido");
        bios.inizializza();
        os.avvia();
    }
}

//classe Facade
class ComputerFacade {
        ////classi base e interfaccia strategy
        private  Bios bios;
        private  HardDisk hardDisk;
        private  SistemaOperativo sistemaOperativo;
        private  AvvioStrategy strategy;

        //costruttore con istanziazione classi e strategy
        public ComputerFacade(AvvioStrategy strategy) {
            this.bios = new Bios();
            this.hardDisk = new HardDisk();
            this.sistemaOperativo = SistemaOperativo.getInstance(); // Singleton
            this.strategy = strategy;
        }

        //metodo facade che richiama strategy
        public void accendiComputer() {
            strategy.avvia(bios, hardDisk, sistemaOperativo);
        }
}

