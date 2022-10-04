package program.not.executable.importsubstitutionstatistics.parser;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import program.not.executable.importsubstitutionstatistics.parser.request.Period;
import program.not.executable.importsubstitutionstatistics.parser.request.RequestBody;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

@SpringBootTest
class ClientTest {

    @Autowired
    private Client client;

    private final Period period = new Period(new Date(2019, Calendar.FEBRUARY, 1),
            new Date(2019, Calendar.FEBRUARY, 28));

    private final RequestBody requestBody = new RequestBody("", "Csv", List.of("03"), List.of(period),
            List.of("18000"), 2);

    @Test
    void makeAndSendRequest() {
        client.makeAndSendRequest(requestBody);
    }
    /*
    {exportType: "Csv", tnved: [], tnvedLevel: 2, federalDistricts: ["03"], subjects: ["18000"],…}
    direction: ""
    exportType: "Csv"
    federalDistricts: ["03"]
    period: [{start: "2019-02-01", end: "2019-02-28"}]
    subjects: ["18000"]
    tnvedLevel: 2
    */
}

