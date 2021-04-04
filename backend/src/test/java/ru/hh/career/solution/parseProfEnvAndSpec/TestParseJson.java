package ru.hh.career.solution.parseProfEnvAndSpec;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


public class TestParseJson {
    public static void main(String[] args) throws JsonProcessingException {
        testParseJson();
    }

    public static void testParseJson() throws JsonProcessingException {
        String test = """
                [
                    {
                        "name": "Спортивные клубы, фитнес, салоны красоты",
                        "id": "24",
                        "specializations": [
                            {
                                "id": "24.493",
                                "name": "Парикмахер",
                                "laboring": false
                            }
                        ]
                    }
                ]""";

        ObjectMapper objectMapper = new ObjectMapper();
        ProfEnvDTO[] value = objectMapper.readValue(test, ProfEnvDTO[].class);
        for (var i : value) {
            System.out.println(i.getId() + ' ' + i.getName());
            for (var j : i.getSpecialization()) {
                System.out.println(j.getId() + ' ' + j.getName() + ' ' + j.getLaboring());
            }
        }
    }
}
