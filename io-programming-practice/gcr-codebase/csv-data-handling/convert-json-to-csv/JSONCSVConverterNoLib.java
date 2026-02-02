import java.io.*;
import java.util.*;
public class JSONCSVConverterNoLib {
    public static void main(String[] args) {
        String jsonFile = "./io-programming-practice/gcr-codebase/csv-data-handling/convert-json-to-csv/students.json";
        String csvFile = "./io-programming-practice/gcr-codebase/csv-data-handling/convert-json-to-csv/students.csv";
        String jsonFromCSV = "./io-programming-practice/gcr-codebase/csv-data-handling/convert-json-to-csv/students_from_csv.json";
        jsonToCSV(jsonFile, csvFile);
        csvToJSON(csvFile, jsonFromCSV);
    }
    private static void jsonToCSV(String jsonFile, String csvFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(jsonFile));
             FileWriter writer = new FileWriter(csvFile)) {
            writer.append("ID,Name,Age,Marks\n");
            String line;
            int id=0, age=0, marks=0;
            String name="";
            while ((line = br.readLine()) != null) {
                line=line.trim();
                if (line.equals("[")||line.equals("]")||line.equals("")||line.equals("{")||line.equals("}")) continue;
                line=line.replace("{","").replace("}","").replace(",","");
                String[] parts=line.split("\"");
                for (int i=1;i<parts.length;i+=2) {
                    String key=parts[i];
                    String value=parts[i+1].replace(":","").trim();
                    switch(key) {
                        case "id" -> id=Integer.parseInt(value);
                        case "name" -> name=value;
                        case "age" -> age=Integer.parseInt(value);
                        case "marks" -> marks=Integer.parseInt(value);
                    }
                }
                writer.append(id+","+name+","+age+","+marks+"\n");
            }
            System.out.println("JSON successfully converted to CSV: "+csvFile);
        } catch(IOException e) { e.printStackTrace(); }
    }
    private static void csvToJSON(String csvFile, String jsonFile) {
        try (BufferedReader br = new BufferedReader(new FileReader(csvFile));
             FileWriter writer = new FileWriter(jsonFile)) {
            br.readLine();
            String line;
            writer.write("[\n");
            List<String> lines=new ArrayList<>();
            while ((line=br.readLine())!=null) {
                String[] data=line.split(",");
                String jsonObj=String.format("{\"id\":%s,\"name\":\"%s\",\"age\":%s,\"marks\":%s}",data[0],data[1],data[2],data[3]);
                lines.add(jsonObj);
            }
            writer.write(String.join(",\n",lines));
            writer.write("\n]");
            System.out.println("CSV successfully converted back to JSON: "+jsonFile);
        } catch(IOException e) { e.printStackTrace(); }
    }
}