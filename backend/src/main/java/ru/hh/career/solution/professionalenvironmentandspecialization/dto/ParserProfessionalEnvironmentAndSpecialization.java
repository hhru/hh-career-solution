package ru.hh.career.solution.professionalenvironmentandspecialization.dto;

import com.fasterxml.jackson.databind.ObjectMapper;
import ru.hh.jclient.common.DefaultRequestStrategy;
import ru.hh.jclient.common.HttpClientContext;
import ru.hh.jclient.common.HttpClientFactory;
import ru.hh.jclient.common.HttpClientFactoryBuilder;
import ru.hh.jclient.common.Request;
import ru.hh.jclient.common.RequestBuilder;
import ru.hh.jclient.common.util.storage.SingletonStorage;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class ParserProfessionalEnvironmentAndSpecialization {

    private Properties getjClientProperty() throws IOException {
        InputStream is = ParserProfessionalEnvironmentAndSpecialization.class.getResourceAsStream("./jclient.properties");
        Properties properties = new Properties();
        properties.load(is);
        if (is == null) {
            return properties;
        }
        is.close();
        return properties;
    }

    public ProfessionalEnvironmentDto[] parse()
            throws IOException, ExecutionException, InterruptedException {
        final ObjectMapper mapper = new ObjectMapper();
        Properties jClientProperty = this.getjClientProperty();
        HttpClientFactory http = new HttpClientFactoryBuilder(new SingletonStorage<>(() ->
                    new HttpClientContext(Map.of(), Map.of(), List.of())), List.of())
                .withProperties(jClientProperty)
                .withRequestStrategy(new DefaultRequestStrategy())
                .withCallbackExecutor(Runnable::run)
                .withHostsWithSession(Collections.singleton(jClientProperty
                        .getProperty("jclient.hostsWithSession")))
                .withUserAgent("my service")
                .build();
        Request request = new RequestBuilder("GET").setUrl("https://api.hh.ru/specializations").build();
        CompletableFuture<ProfessionalEnvironmentDto[]> profEnvDTOFuture = http.with(request)
                .expectJson(mapper, ProfessionalEnvironmentDto[].class).result();
        return profEnvDTOFuture.get();
    }
}
