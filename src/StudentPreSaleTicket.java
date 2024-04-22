public class StudentPreSaleTicket implements Billet {
    private int billetId;
    private String studiekortId;
    private int dageTilEvent;
    private int basisPris = 90;

    public StudentPreSaleTicket(int billetId, int dageTilEvent, String studiekortId) {
        this.billetId = billetId;
        this.dageTilEvent = dageTilEvent;
        this.studiekortId = studiekortId;
    }


    @Override
    public int getPrice() {
        if (dageTilEvent < 10) {
            return basisPris;
        } else {
            return (int) (basisPris * 0.85); // 15% rabat
        }
    }

    @Override
    public String getTicketType() {
        return "Billet i forsalg med studierabat";
    }

    @Override
    public int getTicketId() {
        return billetId;
    }

    public String getStudiekortId() {
        return studiekortId;
    }



    @Override
    public String toString() {
        return "BilletType: " + getTicketType() + ", BilletId: " + billetId + ", Pris: " + getPrice() + " kr. Husk studiekort!";
    }
}