package ru.hh.career.solution.area.dto;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.util.Arrays;

public class AreaDeserializer extends StdDeserializer<AreaDto> {
  public AreaDeserializer() {
    super(AreaDto.class);
  }

  private static final ObjectMapper mapper = new ObjectMapper();

  @Override
  public AreaDto deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException {
    JsonNode treeNode = jsonParser.readValueAsTree();
    if (treeNode == null) {
      return null;
    }
    AreaDto areaDto = new AreaDto();
    areaDto.setId(treeNode.get("id").asInt());
    areaDto.setName(treeNode.get("name").asText());
    areaDto.setParentId(treeNode.get("parent_id").asInt());
    areaDto.setAreaDtos(Arrays.asList(mapper.readValue(treeNode.get("areas").toString(), AreaDto[].class)));
    return areaDto;
  }
}
