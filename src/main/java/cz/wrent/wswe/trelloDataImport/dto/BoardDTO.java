package cz.wrent.wswe.trelloDataImport.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import cz.wrent.wswe.trelloDataImport.trello.dto.Board;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "_Builder")
@JsonDeserialize(builder = BoardDTO._Builder.class)
public class BoardDTO {

  private final String id;
  private final String name;

  public static BoardDTO map(Board input) {
    return new _Builder()
        .id(input.getId())
        .name(input.getName())
        .build();
  }

  @JsonPOJOBuilder(withPrefix = "")
  public static class _Builder {

  }
}
