public class PreSaleTicket implements Billet{
    private int billetId;
    private int dageTilEvent;
    private int basisPris = 120;

    public PreSaleTicket(int billetId, int dageTilEvent) {
        this.billetId = billetId;
        this.dageTilEvent = dageTilEvent;
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
        return "Billet i forsalg";
    }

    @Override
    public int getTicketId() {
        return billetId;
    }

    @Override
    public String toString() {
        return "BilletType: " + getTicketType() + ", BilletId: " + billetId + ", Pris: " + getPrice() + " kr";
    }
}


