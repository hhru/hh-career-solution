package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;


public class SpecializationsDeserializer extends StdDeserializer<SpecializationsDTO> {
    public SpecializationsDeserializer() {
        super(SpecializationsDeserializer.class);
    }

    @Override
    public SpecializationsDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        SpecializationsDTO specDTO = new SpecializationsDTO();
        JsonNode treeNode = jsonParser.readValueAsTree();
        if (treeNode == null) {
            return null;
        }
        specDTO.setId(treeNode.get("id").asInt());
        specDTO.setName(treeNode.get("name").asText());

        return specDTO;
    }
}
