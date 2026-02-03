package com.lakshya.IplCensorAnalyzer;
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
public class CsvCensorProcessor {
    public List<IplMatch> readCsv(String filePath) throws Exception {
        List<IplMatch> matches = new ArrayList<>();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] line;
            while ((line = reader.readNext()) != null) {
                if (line.length == 0 ||
                    line[0].trim().equalsIgnoreCase("match_id") ||
                    !line[0].trim().matches("\\d+")) {
                    continue;
                }
                IplMatch match = new IplMatch();
                match.setMatch_id(Integer.parseInt(line[0].trim()));
                match.setTeam1(line[1].trim());
                match.setTeam2(line[2].trim());
                Map<String, Integer> scoreMap = new HashMap<>();
                scoreMap.put(line[1].trim(), Integer.parseInt(line[3].trim()));
                scoreMap.put(line[2].trim(), Integer.parseInt(line[4].trim()));
                match.setScore(scoreMap);
                match.setWinner(line[5].trim());
                match.setPlayer_of_match(line[6].trim());
                matches.add(match);
            }
        }
        return matches;
    }
    public void writeCsv(String filePath, List<IplMatch> matches) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(filePath))) {
            writer.writeNext(new String[]{"match_id","team1","team2","score_team1","score_team2","winner","player_of_match"});
            for (IplMatch match : matches) {
                String score1 = match.getScore().getOrDefault(match.getTeam1(), 0).toString();
                String score2 = match.getScore().getOrDefault(match.getTeam2(), 0).toString();
                writer.writeNext(new String[]{
                        String.valueOf(match.getMatch_id()),
                        match.getTeam1(),
                        match.getTeam2(),
                        score1,
                        score2,
                        match.getWinner(),
                        match.getPlayer_of_match()
                });
            }
        }
    }
}