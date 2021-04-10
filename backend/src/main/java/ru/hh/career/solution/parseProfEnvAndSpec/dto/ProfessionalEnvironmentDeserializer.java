package ru.hh.career.solution.parseProfEnvAndSpec.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;


public class ProfessionalEnvironmentDeserializer extends StdDeserializer<ProfessionalEnvironmentDTO> {
    public ProfessionalEnvironmentDeserializer() {
        super(ProfessionalEnvironmentDTO.class);
    }

    @Override
    public ProfessionalEnvironmentDTO deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
        ProfessionalEnvironmentDTO profEnv = new ProfessionalEnvironmentDTO();
        JsonNode treeNode = jsonParser.readValueAsTree();
        if (treeNode == null) {
            return null;
        }
        profEnv.setId(treeNode.get("id").asInt());
        profEnv.setName(treeNode.get("name").asText());
        ObjectMapper objectMapper = new ObjectMapper();
        SpecializationsDto[] specDTOS = objectMapper.readValue(treeNode.get("specializations").toString(), SpecializationsDto[].class);
        profEnv.setSpecialization(Arrays.asList(specDTOS));
        return profEnv;
    }
}
