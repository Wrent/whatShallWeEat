package cz.wrent.wswe.trelloDataImport.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "_Builder")
@JsonDeserialize(builder = BoardDTO._Builder.class)
public class ResponseDTO {

  private final boolean isOk;

  @JsonPOJOBuilder(withPrefix = "")
  public static class _Builder {

  }
}
