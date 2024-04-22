import java.util.*;

public class SolgteBilletter {
    private List<Billet> billetter;

    public SolgteBilletter() {
        this.billetter = new ArrayList<>();
    }

    public void tilfoejBillet(Billet billet) {
        billetter.add(billet);
    }

    public String toString() {
        List<Billet> sortedBilletter = new ArrayList<>(billetter);
        Collections.sort(sortedBilletter, Comparator.comparing(Billet::getTicketId));

        StringBuilder output = new StringBuilder();
        for (Billet billet : sortedBilletter) {
            output.append(billet.toString()).append("\\n");
        }
        return output.toString();
    }
    public int[] antalAfHverSlags(){
        int doorCount = 0;
        int preSaleCount = 0;
        int studentPreSaleCount = 0;

        for(Billet billet : billetter) {
            if(billet instanceof DoorTicket) {
                doorCount++;
            }
             else if (billet instanceof PreSaleTicket){
                 preSaleCount++;
            }
             else if( billet instanceof StudentPreSaleTicket){
                 studentPreSaleCount++;
            }
        }
        return new int [] {
                doorCount, preSaleCount, studentPreSaleCount};

    }
    public String hentAlleStudieKort(){
        List<String> studieKortIdList = new ArrayList<>();
        for(Billet billet : billetter){
            if(billet instanceof StudentPreSaleTicket){
                studieKortIdList.add(((StudentPreSaleTicket) billet).getStudiekortId());
            }
        }
        Collections.sort(studieKortIdList);
        return String.join(" , ", studieKortIdList);

    }
}
