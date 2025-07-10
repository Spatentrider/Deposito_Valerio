public class EsempiCondizioni{
    public static void main(String[] args) {
        //esempio espressioni booleane
        int x = 10;
        int y = 9;
        System.out.println(x > y);

        //esempio espressioni booleane con variabili 
        int myAge = 25;
        int votingAge = 18;
        System.out.println(myAge > votingAge);

        //esempio condizione if
        if(20 > 18) {
            System.out.println("20 is greater than 18");
        }

        //esempio condizione if con variabili
        int x2 = 20;
        int y2 = 18;
        if(x2 > y2){
            System.out.println("x is greater than y");
        }

        //esempio condizione if con else
        //dichiarazione e assegnazione variabile time
        int time = 20;
        //blocco if else con stampa
        if(time < 18){
            System.out.println("Good day");
        } else {
            System.out.println("Good evening");
        }

        //esempio condizione if, else if e else
        //dichiarazione e assegnazione variabile time
        int time2 = 22;
        //blocco if else con stampa
        if(time2 < 10){
            System.err.println("Good morning.");
        } else if (time2 < 18) {
            System.out.println("Good day");
        } else {
            System.out.println("Good evening");
        } //outputs Good day

        //esempio operatore ternario
        int time3= 20;
        String result = (time3 < 18) ? "Good day." : "Good evening.";
        System.out.println(result);

        //esempio condizione switch
        int day = 4;
        switch(day){
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("Tuesday");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;
        }
}}