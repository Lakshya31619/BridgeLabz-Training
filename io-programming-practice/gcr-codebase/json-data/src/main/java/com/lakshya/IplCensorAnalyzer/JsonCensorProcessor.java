package com.lakshya.IplCensorAnalyzer;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.File;
import java.util.List;
public class JsonCensorProcessor {
    private final ObjectMapper mapper = new ObjectMapper();
    public List<IplMatch> readJson(String filePath) throws Exception {
        return mapper.readValue(new File(filePath), new TypeReference<List<IplMatch>>() {});
    }
    public void writeJson(String filePath, List<IplMatch> matches) throws Exception {
        mapper.writerWithDefaultPrettyPrinter().writeValue(new File(filePath), matches);
    }
}