package ru.hh.career.solution.professionalenvironment.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;


public class ProfessionalEnvironmentDeserializer extends StdDeserializer<ProfessionalEnvironmentDto> {
  public ProfessionalEnvironmentDeserializer() {
    super(ProfessionalEnvironmentDto.class);
  }

  private static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public ProfessionalEnvironmentDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    JsonNode treeNode = jsonParser.readValueAsTree();
    if (treeNode == null) {
      return null;
    }
    ProfessionalEnvironmentDto professionalEnvironmentDto = new ProfessionalEnvironmentDto();
    professionalEnvironmentDto.setId(treeNode.get("id").asInt());
    professionalEnvironmentDto.setName(treeNode.get("name").asText());
    SpecializationDto[] specializationDtos = mapper.readValue(treeNode.get("specializations").toString(), SpecializationDto[].class);
    professionalEnvironmentDto.setSpecialization(Arrays.asList(specializationDtos));
    return professionalEnvironmentDto;
  }
}
