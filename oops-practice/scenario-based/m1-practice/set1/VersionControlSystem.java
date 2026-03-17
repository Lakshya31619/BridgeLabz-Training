import java.util.*;

class FileVersion {
    String version;
    int size;

    FileVersion(String v, int s) {
        version = v;
        size = s;
    }
}

public class VersionControlSystem {
    static Map<String, List<FileVersion>> map = new HashMap<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        while (n-- > 0) {
            String[] input = sc.nextLine().split(" ");
            String cmd = input[0];

            switch (cmd) {
                case "UPLOAD":
                    upload(input[1], input[2], Integer.parseInt(input[3]));
                    break;
                case "FETCH":
                    fetch(input[1]);
                    break;
                case "LATEST":
                    latest(input[1]);
                    break;
                case "TOTAL_STORAGE":
                    total(input[1]);
                    break;
            }
        }
    }

    static void upload(String file, String version, int size) {
        map.putIfAbsent(file, new ArrayList<>());

        for (FileVersion fv : map.get(file)) {
            if (fv.version.equals(version)) return;
        }

        map.get(file).add(new FileVersion(version, size));
    }

    static void fetch(String file) {
        if (!map.containsKey(file)) {
            System.out.println("File Not Found");
            return;
        }

        List<FileVersion> list = new ArrayList<>(map.get(file));
        list.sort((a, b) -> {
            if (a.size != b.size) return a.size - b.size;
            return a.version.compareTo(b.version);
        });

        for (FileVersion fv : list) {
            System.out.println(file + " " + fv.version + " " + fv.size);
        }
    }

    static void latest(String file) {
        if (!map.containsKey(file) || map.get(file).isEmpty()) {
            System.out.println("File Not Found");
            return;
        }

        FileVersion fv = map.get(file).get(map.get(file).size() - 1);
        System.out.println(file + " " + fv.version + " " + fv.size);
    }

    static void total(String file) {
        if (!map.containsKey(file)) {
            System.out.println("File Not Found");
            return;
        }

        int sum = 0;
        for (FileVersion fv : map.get(file)) {
            sum += fv.size;
        }

        System.out.println(file + " " + sum);
    }
}