package ru.hh.career.solution.parseProfEnvAndSpec;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;
import ru.hh.career.solution.parseProfEnvAndSpec.ProfEnvDTO;
import ru.hh.career.solution.parseProfEnvAndSpec.SpecDTO;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;


public class SpecDeserializer extends StdDeserializer<ProfEnvDTO> {
    public SpecDeserializer() {
        super(ProfEnvDTO.class);
    }

    @Override
    public ProfEnvDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ProfEnvDTO profEnv = new ProfEnvDTO();
        JsonNode treeNode = jsonParser.readValueAsTree();
        if (treeNode == null) {
            return null;
        }
        profEnv.setId(treeNode.get("id").asInt());
        profEnv.setName(treeNode.get("name").asText());
        ObjectMapper objectMapper = new ObjectMapper();
        SpecDTO[] specDTOS = objectMapper.readValue(treeNode.get("specializations").toString(), SpecDTO[].class);
        profEnv.setSpecialization(Arrays.asList(specDTOS));
        return profEnv;
    }
}
