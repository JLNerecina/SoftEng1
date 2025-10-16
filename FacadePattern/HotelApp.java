public class HotelApp {
    public static void main(String[] args) {
        FrontDesk frontDesk = new FrontDesk();
        
        frontDesk.requestValet("AZA643");
        frontDesk.requestHouseKeeping("203");
        frontDesk.requestCart(2);
    }
}