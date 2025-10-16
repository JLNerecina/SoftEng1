public class Valet implements HotelService {
    public void executeService(String plateNumber) {
        pickUpVehicle(plateNumber);
    }

    private void pickUpVehicle(String plateNumber) {
        System.out.println("Valet service: Picking up vehicle with plate number " + plateNumber);
    }
}