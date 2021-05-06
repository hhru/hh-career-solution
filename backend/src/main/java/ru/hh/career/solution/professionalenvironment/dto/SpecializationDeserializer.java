package ru.hh.career.solution.professionalenvironment.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;


public class SpecializationDeserializer extends StdDeserializer<SpecializationDto> {
  public SpecializationDeserializer() {
    super(SpecializationDeserializer.class);
  }

  @Override
  public SpecializationDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    SpecializationDto specializationDto = new SpecializationDto();
    JsonNode treeNode = jsonParser.readValueAsTree();
    if (treeNode == null) {
      return null;
    }
    specializationDto.setProfessionalEnvironmentId(Integer.parseInt(treeNode.get("id").asText().split("\\.")[0]));
    specializationDto.setSpecializationId(Integer.parseInt(treeNode.get("id").asText().split("\\.")[1]));
    specializationDto.setName(treeNode.get("name").asText());
    specializationDto.setLaboring(treeNode.get("laboring").asBoolean());
    return specializationDto;
  }
}
