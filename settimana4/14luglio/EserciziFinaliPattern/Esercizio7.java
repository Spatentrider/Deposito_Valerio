//interfaccia componente
interface ComponenteTesto {
    String mostra();
}

//componente concreto con testo base
class TestoSemplice implements ComponenteTesto {
    private String testo;

    public TestoSemplice(String testo) {
        this.testo = testo;
    }

    @Override
    public String mostra() {
        return testo;
    }
}

//decoratore astratto
abstract class DecoratoreTesto implements ComponenteTesto {
    protected ComponenteTesto componente;

    public DecoratoreTesto(ComponenteTesto componente) {
        this.componente = componente;
    }
}

//decoratore concreto grassetto
class DecoratoreGrassetto extends DecoratoreTesto {
    public DecoratoreGrassetto(ComponenteTesto componente) {
        super(componente);
    }

    @Override
    public String mostra() {
        return "\u001B[1m" + componente.mostra() + "\u001B[0m";
    }
}
//decoratore concreto corsivo
class DecoratoreCorsivo extends DecoratoreTesto {
    public DecoratoreCorsivo(ComponenteTesto componente) {
        super(componente);
    }

    @Override
    public String mostra() {
        return "\u001B[3m" + componente.mostra() + "\u001B[0m";
    }
}
//decoratore concreto sottolineato
class DecoratoreSottolineato extends DecoratoreTesto {
    public DecoratoreSottolineato(ComponenteTesto componente) {
        super(componente);
    }

    @Override
    public String mostra() {
        return "\u001B[4m" + componente.mostra() + "\u001B[0m";
    }
}

//interfaccia strategia
interface StrategiaSalvataggio {
    void salva(String testo);
}

// Strategie Concrete
class SalvataggioLocale implements StrategiaSalvataggio {
    @Override
    public void salva(String testo) {
        System.out.println("Testo salvato in locale: " + testo);
    }
}

class SalvataggioCloud implements StrategiaSalvataggio {
    @Override
    public void salva(String testo) {
        System.out.println("Testo salvato nel cloud: " + testo);
    }
}

class SalvataggioCriptato implements StrategiaSalvataggio {
    @Override
    public void salva(String testo) {
        System.out.println("Testo salvato in modo criptato: " + testo);
    }
}

//Context strategy
class EditorTesto {
    private ComponenteTesto componenteTesto;
    private StrategiaSalvataggio strategiaSalvataggio;

    public EditorTesto(ComponenteTesto componenteTesto) {
        this.componenteTesto = componenteTesto;
    }

    //implementazione decorator
    public void impostaComponenteTesto(ComponenteTesto componenteTesto) {
        this.componenteTesto = componenteTesto;
    }

    //metodo per cambiare strategy
    public void impostaStrategiaSalvataggio(StrategiaSalvataggio strategiaSalvataggio) {
        this.strategiaSalvataggio = strategiaSalvataggio;
    }


    //metodo che richiama metodo della strategy e decorator
    public void salvaTesto() {
        if (strategiaSalvataggio == null) {
            System.out.println("Errore: nessuna strategia di salvataggio selezionata");
            return;
        }
        strategiaSalvataggio.salva(componenteTesto.mostra());
    }

    //metodo stampa
    public void mostraTesto() {
        System.out.println("Testo corrente: " + componenteTesto.mostra());
    }
}
