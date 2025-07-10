import java.util.Scanner;

// Interfaccia IShape per Factory e Decorator
interface IShape {
    void Draw();
}

//Implementazione concreta Cerchio
class Circle implements IShape {
    @Override
    public void Draw() {
         System.out.println("Disegno un cerchio:");
        System.out.println("  ---  ");
        System.out.println(" -   - ");
        System.out.println("-     -");
        System.out.println(" -   - ");
        System.out.println("  ---  ");
    }
}

// Implementazione concreta Quadrato
class Square implements IShape {
    @Override
    public void Draw() {
        System.out.println("Disegno un quadrato:");
        System.out.println("-------");
        System.out.println("-     -");
        System.out.println("-     -");
        System.out.println("-     -");
        System.out.println("-------");
    }
}

// Decorator astratto per IShape
abstract class ShapeDecorator implements IShape {
    //interfaccia protetta
    protected IShape decoratedShape;
    //costruttore con parametro interfaccia
    public ShapeDecorator(IShape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }

    @Override
    //metodo che richiama metodo dell'interfaccia
    public void Draw() {
        decoratedShape.Draw();
    }
}

// Decorator concreto che aggiunge una cornice
class FramedShapeDecorator extends ShapeDecorator {

    //costruttore con metodo super dell'interfaccia
    public FramedShapeDecorator(IShape decoratedShape) {
        super(decoratedShape);
    }

    //metodo decorator con metodo super e aggiunge 2 stampe extra
    @Override
    public void Draw() {
        System.out.println("----- Inizio cornice -----");
        super.Draw();
        System.out.println("----- Fine cornice -----");
    }
}

// Classe astratta ShapeCreator Factory 
abstract class ShapeCreator {
    public abstract IShape CreateShape(String type);
}

//Concrete Creator di circle
class ConcreteShapeCreatorCircle extends ShapeCreator {
    @Override
    public IShape CreateShape(String type) {
        if (type.equals("circle")) {
            return new Circle();
        }
        return null;
    }
}

//Concrete Creator di square
class ConcreteShapeCreatorSquare extends ShapeCreator {
    @Override
    public IShape CreateShape(String type) {
        if (type.equals("square")) {
            return new Square();
        }
        return null;
    }
}

// Facade per il menu
class ShapeDrawingFacade {
    //creazione oggetto Scanner
    private Scanner scanner = new Scanner(System.in);

    //metodo che avvia il menu
    public void avviaMenu() {
        String input;
        do {
            System.out.print("Inserisci circle, square o esci: ");
            input = scanner.nextLine();

            //caso per uscire
            if (input.equals("esci")) {
                System.out.println("Chiusura programma.");
                break;
            }

            //creazione ShapeCreator
            ShapeCreator creator = null;
            //creazione degli oggetti concreti tramite input
            if (input.equals("circle")) {
                creator = new ConcreteShapeCreatorCircle();
            } else if (input.equals("square")) {
                creator = new ConcreteShapeCreatorSquare();
            }

            if (creator != null) {
                IShape shape = creator.CreateShape(input);
                if (shape != null) {
                    //richiesta per decoratore
                    System.out.print("Vuoi aggiungere il bordo decoratore? (sì/no): ");
                    String risposta = scanner.nextLine();
                    //se si aggiunge decoratore all'oggetto
                    if (risposta.equals("sì") || risposta.equalsIgnoreCase("si")) {
                        shape = new FramedShapeDecorator(shape);
                    }
                    // Disegna la forma
                    shape.Draw();
                } else {
                    System.out.println("Errore nella creazione della forma.");
                }
            } else {
                System.out.println("Forma non riconosciuta.");
            }

        } while (true);
    }
}