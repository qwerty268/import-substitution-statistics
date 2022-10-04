package program.not.executable.importsubstitutionstatistics.parser.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
public class RequestBody {
    private String direction;
    private String exportType = "Csv";
    private List<String> federalDistricts = new ArrayList<>();
    private List<Period> period;
    private List<String> subjects;
    private int tnvedLevel;
}
