package program.not.executable.importsubstitutionstatistics.parser;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

import java.util.List;


@Service
public class client {
    protected final RestTemplate rest;

    private static final String PATH = "http://stat.customs.gov.ru/api/DataAnalysis/UnloadData";

    @Autowired
    public client(RestTemplateBuilder builder) {
        this.rest = builder.uriTemplateHandler(new DefaultUriBuilderFactory(PATH))
                .build();
    }

    private RequestBody createRequest() {
        RequestBody requestBody = new RequestBody();
        return requestBody;
    }

    private HttpHeaders getHeaders() {
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        httpHeaders.add("Content-Type", "application/zip");
        return httpHeaders;
    }

    private ResponseEntity<Object> makeAndSendRequest(RequestBody requestBody) {
        HttpEntity<RequestBody> requestEntity = new HttpEntity<>(requestBody, getHeaders());

        ResponseEntity<Object> shareitServerResponse;

        try {
            shareitServerResponse = rest.exchange(PATH, HttpMethod.POST, requestEntity, Object.class);
        } catch (HttpStatusCodeException e) {
            return ResponseEntity.status(e.getStatusCode()).body(e.getResponseBodyAsByteArray());
        }
        return null;
    }

}
