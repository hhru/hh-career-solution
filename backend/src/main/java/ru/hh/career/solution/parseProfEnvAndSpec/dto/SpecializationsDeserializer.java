package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;


public class SpecializationsDeserializer extends StdDeserializer<SpecializationsDto> {
    public SpecializationsDeserializer() {
        super(SpecializationsDeserializer.class);
    }

    @Override
    public SpecializationsDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        SpecializationsDto specDto = new SpecializationsDto();
        JsonNode treeNode = jsonParser.readValueAsTree();
        if (treeNode == null) {
            return null;
        }
        specDto.setId(Integer.parseInt(treeNode.get("id").asText().split(".")[1]));
        specDto.setName(treeNode.get("name").asText());
        specDto.setLaboring(treeNode.get("laboring").asBoolean());
        return specDto;
    }
}
