public class Volume_Earth {
    public static void main(String[] args) {
        int r_km = 6378;
        double r_m = 6378*0.621371;
        double volume_km = (4*3.14*Math.pow(r_km,3))/3;
        double volume_m = (4*3.14*Math.pow(r_m,3))/3;
        System.out.println("The volume of Earth in cubic kilometers is "+volume_km+" and cubic miles is "+volume_m);
    }
}
