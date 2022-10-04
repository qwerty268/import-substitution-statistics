package program.not.executable.importsubstitutionstatistics.parser;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class RequestBody {
    private String direction;
    private static String exportType = "Csv";
    private List<String> federalDistricts = new ArrayList<>();
    private List<Period> period;
    private List<String> subjects;
    private int tnvedLevel;
}
