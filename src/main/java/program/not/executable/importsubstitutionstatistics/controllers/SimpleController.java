package program.not.executable.importsubstitutionstatistics.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import program.not.executable.importsubstitutionstatistics.parser.request.PeriodDTO;

@RestController("/simple")
public class SimpleController {
    @GetMapping
    public PeriodDTO getPeriod() {
        return new PeriodDTO("222", "222");
    }
}
