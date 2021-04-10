package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.jclient.common.*;
import ru.hh.jclient.common.util.storage.SingletonStorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParseProfessionalEnvironmentAndSpecialization {
    private ProfessionalEnvironmentDTO[] value;

    public ProfessionalEnvironmentDTO[] getValue() {
        return value;
    }

    public void setValue(ProfessionalEnvironmentDTO[] value) {
        this.value = value;
    }

    private Properties getjClientProperty() throws IOException {
        InputStream is = ParseProfessionalEnvironmentAndSpecialization.class.getResourceAsStream("./jclient.properties");
        Properties properties = new Properties();
        properties.load(is);
        if (is != null) is.close();
        return properties;
    }

    public ProfessionalEnvironmentDTO[] parse() throws IOException, ExecutionException, InterruptedException {
        ObjectMapper mapper = new ObjectMapper();
        Properties jClientProperty = this.getjClientProperty();
        HttpClientFactory http = new HttpClientFactoryBuilder(new SingletonStorage<>(() -> new HttpClientContext(Map.of(), Map.of(), List.of())), List.of())
                .withProperties(jClientProperty)
                .withRequestStrategy(new DefaultRequestStrategy())
                .withCallbackExecutor(Runnable::run)
                .withHostsWithSession(Collections.singleton(jClientProperty.getProperty("jclient.hostsWithSession")))
                .withUserAgent("my service")
                .build();
        Request request = new RequestBuilder("GET").setUrl("https://api.hh.ru/specializations").build();
        CompletableFuture<ProfessionalEnvironmentDTO[]> profEnvDTOFuture = http.with(request).expectJson(mapper, ProfessionalEnvironmentDTO[].class).result();
        this.setValue(profEnvDTOFuture.get());
        return this.getValue();
    }
}
