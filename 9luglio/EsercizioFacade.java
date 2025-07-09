// Sottosistema LuceCamera
class LuceCamera {
    void accendi() {
        System.out.println("Accesa luce della camera");
    }
}

// Sottosistema LuciCucina
class LuceCucina {
    void accendi() {
        System.out.println("Accesa luce della cucina");
    }
}

// Facade
class GestioneLuciFacade {
    //istanze private delle classi LuceCamera e LuceCucina
    private LuceCamera camera = new LuceCamera();
    private LuceCucina cucina = new LuceCucina();

    //metodo che chiama metodo di LuceCamera e LuceCucina
    public void accendiTutte() {
        camera.accendi();
        cucina.accendi();
    }
}