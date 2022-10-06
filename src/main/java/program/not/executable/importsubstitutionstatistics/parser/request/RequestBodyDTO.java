package program.not.executable.importsubstitutionstatistics.parser.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@Data
public class RequestBodyDTO {
    private String direction;
    private String exportType = "Csv";
    private List<String> federalDistricts = new ArrayList<>();
    private List<PeriodDTO> period;
    private List<String> subjects;
    private int tnvedLevel;
}
