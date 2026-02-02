public class DependencyInjection {
    public static void main(String[] args) throws Exception {
        DIContainer container = new DIContainer();
        Car car = container.getBean(Car.class);
        car.drive();
    }
}