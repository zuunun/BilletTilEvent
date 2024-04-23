import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SolgteBilletter solgteBilletter = new SolgteBilletter();

        System.out.println("Hvor mange billetter vil du gerne tilføje?");
        int antalBilletter = scanner.nextInt();
        scanner.nextLine();

        for(int i = 0; i < antalBilletter; i++){
            System.out.println("Tilføjelse af billet #" + (i+1));

            System.out.println("Insert ticket id:");
            int ticketId = scanner.nextInt();

            System.out.println("Is this a doorticket(d), presaleticket (p) or a studentpresaleticket (s)?");
            String ticketType = scanner.nextLine().trim().toLowerCase();
            scanner.nextLine();

            System.out.println("How many days are there till the event?");
            int daysTillEvent = scanner.nextInt();
            scanner.nextLine();

            if(ticketType.equals("d")){
                solgteBilletter.tilfoejBillet(new DoorTicket(ticketId));
            }
            else if (ticketType.equals("p")){
                solgteBilletter.tilfoejBillet(new PreSaleTicket(ticketId, daysTillEvent));
            }
            else if(ticketType.equals("s")){
                solgteBilletter.tilfoejBillet(new StudentPreSaleTicket(ticketId,
                        daysTillEvent, solgteBilletter.hentAlleStudieKort()));
            }
            System.out.println();
        }
        System.out.println("Alle solgte billetter:");
        System.out.println(solgteBilletter.toString());

        int[] antalAfHverSlags = solgteBilletter.antalAfHverSlags();
        System.out.println("Antal billetter solgt:");
        System.out.println("-----Dør billetter: " + antalAfHverSlags[0]);
        System.out.println("-----Forsalgs billetter " + antalAfHverSlags[1]);
        System.out.println("-----Studie billetter " + antalAfHverSlags[2]);

        String studiekortIds = solgteBilletter.hentAlleStudieKort();
        System.out.println("StudieKort-ID'er for solgte studiebilletter: ");
        System.out.println(studiekortIds);


    }
}