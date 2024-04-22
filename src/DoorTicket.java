public class DoorTicket implements Billet{
    private  int billetId;
    private int pris = 150;

    public DoorTicket(int billetId) {
        this.billetId = billetId;
    }

    @Override
    public int getPrice() {
        return pris;
    }

    @Override
    public String getTicketType() {
        return "Billet i døren";
    }

    @Override
    public int getTicketId() {
        return billetId;
    }

    @Override
    public String toString() {
        return "BilletType: " + getTicketType() + ", BilletId: " + billetId + ", Pris: " + pris + " kr";
    }

}
