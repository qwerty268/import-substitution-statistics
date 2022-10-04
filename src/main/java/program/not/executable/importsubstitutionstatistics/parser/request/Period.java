package program.not.executable.importsubstitutionstatistics.parser.request;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

@Data
@AllArgsConstructor
public class Period {
    private Date end;
    private Date start;
}
