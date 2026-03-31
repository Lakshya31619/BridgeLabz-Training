//Driver class
class Driver{
    private int driverID;
    private String name;
    private boolean available = true;
    public Driver(int driverID, String name){
        this.driverID = driverID;
        this.name = name;
    }
    public boolean isAvailable(){
        return available;
    }
    public void assignRide(){
        available = false;
    }
    public void completeRide(){
        available = true;
    }
    public String getName(){
        return name;
    }
}