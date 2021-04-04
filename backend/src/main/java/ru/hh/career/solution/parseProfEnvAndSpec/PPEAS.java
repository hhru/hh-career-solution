package ru.hh.career.solution.parseProfEnvAndSpec;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class PPEAS {
    private ProfEnvDTO[] value;

    public ProfEnvDTO[] getValue() {
        return value;
    }

    public void parse() throws IOException {
        URL url = new URL("https://api.hh.ru/specializations");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        this.value = mapper.readValue(url, ProfEnvDTO[].class);

    }
}
