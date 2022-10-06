package program.not.executable.importsubstitutionstatistics.parser.request;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class PeriodDTO {
    private final String end;
    private final String start;
}
