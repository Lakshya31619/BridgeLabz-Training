public class Bus implements Rentable {
    @Override
    public void rent() {
        System.out.println("Bus has been rented for group travel");
    }
    @Override
    public void returnVehicle() {
        System.out.println("Bus has been returned");
    }
}