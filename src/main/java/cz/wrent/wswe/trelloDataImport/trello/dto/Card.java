package cz.wrent.wswe.trelloDataImport.trello.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import java.util.List;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "_Builder")
@JsonDeserialize(builder = Card._Builder.class)
public class Card {

  private final String id;
  private final String name;
  private final String desc;
  private final List<Label> labels;

  @JsonPOJOBuilder(withPrefix = "")
  public static class _Builder {

  }
}
