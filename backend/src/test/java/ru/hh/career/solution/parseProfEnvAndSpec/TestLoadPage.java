package ru.hh.career.solution.parseProfEnvAndSpec;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.net.URL;

public class TestLoadPage {
    public static void main(String[] args) throws IOException {
        testLoadPage();
    }

    private static void testLoadPage() throws IOException {
        URL url = new URL("https://api.hh.ru/specializations");
        ObjectMapper mapper = new ObjectMapper(); // create once, reuse
        ProfEnvDTO[] value = mapper.readValue(url, ProfEnvDTO[].class);
        for (var i : value) {
            System.out.println(i.getId() + ' ' + i.getName());
            for (var j : i.getSpecialization()) {
                System.out.println(j.getId() + ' ' + j.getName() + ' ' + j.getLaboring());
            }
        }
    }
}
