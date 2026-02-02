class Student {
    private String name;
    private int age;
    public Student() {
        this.name = "Unknown";
        this.age = 0;
    }
    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }
    public void display() {
        System.out.println("Name: " + name + ", Age: " + age);
    }
}