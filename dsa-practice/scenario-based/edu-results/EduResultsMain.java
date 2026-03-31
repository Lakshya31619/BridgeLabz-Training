public class EduResultsMain {
    public static void main(String[] args) {
        Student[] district1 = {new Student(101, "Ansh", 85), new Student(102, "Neha", 78)};
        Student[] district2 = {new Student(201, "Naman", 92), new Student(202, "Duanshi", 85)};
        Student[] district3 = {new Student(301, "Sumit", 88), new Student(302, "Tanya", 75)};
        Student[] stateList = new Student[district1.length + district2.length + district3.length];
        int index = 0;
        for (Student s : district1) stateList[index++] = s;
        for (Student s : district2) stateList[index++] = s;
        for (Student s : district3) stateList[index++] = s;
        MergeSort.mergeSort(stateList, 0, stateList.length - 1);
        System.out.println("STATE-WISE RANK LIST");
        System.out.println("Rank | Roll | Name | Marks");
        int rank = 1;
        for (Student s : stateList) {
            System.out.println(rank++ + " | " + s);
        }
    }
}