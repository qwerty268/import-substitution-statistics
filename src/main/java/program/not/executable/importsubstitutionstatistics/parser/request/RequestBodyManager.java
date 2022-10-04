package program.not.executable.importsubstitutionstatistics.parser.request;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class RequestBodyManager {
    private static final SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");

    public static RequestBodyDTO requestToDTO(RequestBody request) {
        List<PeriodDTO> periodDTOS = periodToDTO(request.getPeriod());

        return new RequestBodyDTO(request.getDirection(),
                request.getExportType(),
                request.getFederalDistricts(),
                periodDTOS,
                request.getSubjects(),
                request.getTnvedLevel());
    }

    private static List<PeriodDTO> periodToDTO(List<Period> periods) {
        List<PeriodDTO> periodDTOS = new ArrayList<>();

        for (Period period : periods) {
            periodDTOS.add(new PeriodDTO(formatter.format(period.getEnd()), formatter.format(period.getStart())));
        }
        return periodDTOS;
    }
}
