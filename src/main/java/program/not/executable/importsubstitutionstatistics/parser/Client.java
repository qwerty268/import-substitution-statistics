package program.not.executable.importsubstitutionstatistics.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;
import program.not.executable.importsubstitutionstatistics.parser.request.RequestBody;
import program.not.executable.importsubstitutionstatistics.parser.request.RequestBodyDTO;
import program.not.executable.importsubstitutionstatistics.parser.request.RequestBodyManager;


@Service
public class Client {
    protected final RestTemplate rest;

    private static final String PATH = "http://stat.customs.gov.ru/api/DataAnalysis/UnloadData";

    @Autowired
    public Client(RestTemplateBuilder builder) {
        this.rest = builder.uriTemplateHandler(new DefaultUriBuilderFactory(PATH))
                .build();
    }


    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Content-Type", "application/zip");
        return httpHeaders;
    }

    public ResponseEntity<Object> makeAndSendRequest(RequestBody body) {
        RequestBodyDTO requestBody = RequestBodyManager.requestToDTO(body);

        HttpEntity<RequestBodyDTO> requestEntity = new HttpEntity<>(requestBody, getHeaders());

        ResponseEntity<Object> substitutionApiResponse;

        try {
            substitutionApiResponse = rest.exchange(PATH, HttpMethod.POST, requestEntity, Object.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsByteArray());
        }
        return null;
    }

}
