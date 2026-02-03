package com.lakshya.IplCensorAnalyzer;
import java.util.List;
public class IPLCensorAnalyzer {
    public static void main(String[] args) {
        try {
            JsonCensorProcessor jsonProcessor = new JsonCensorProcessor();
            List<IplMatch> jsonMatches = jsonProcessor.readJson("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/IplCensorAnalyzer/data.json");
            jsonMatches.forEach(IplMatch::applyCensorship);
            jsonProcessor.writeJson("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/IplCensorAnalyzer/censored_matches.json", jsonMatches);
            CsvCensorProcessor csvProcessor = new CsvCensorProcessor();
            List<IplMatch> csvMatches = csvProcessor.readCsv("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/IplCensorAnalyzer/data.csv");
            csvMatches.forEach(IplMatch::applyCensorship);
            csvProcessor.writeCsv("./io-programming-practice/gcr-codebase/json-data/src/main/java/com/lakshya/IplCensorAnalyzer/censored_matches.csv", csvMatches);
            System.out.println("Censorship complete! Files generated in /output folder.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}