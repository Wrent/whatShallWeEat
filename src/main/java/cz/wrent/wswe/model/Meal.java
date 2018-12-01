package cz.wrent.wswe.model;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import cz.wrent.wswe.trelloDataImport.trello.dto.Card;
import lombok.Builder;
import lombok.Data;
import lombok.experimental.Wither;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Builder(builderClassName = "_Builder")
@JsonDeserialize(builder = cz.wrent.wswe.trelloDataImport.dto.BoardDTO._Builder.class)
@Document
public class Meal {

  @Id
  @Wither
  private final String id;
  private final String name;
  private final String description;

  public static Meal fromCard(Card card) {
    return Meal.builder()
        .name(card.getName())
        .description(card.getDesc())
        .build();
  }

  @JsonPOJOBuilder(withPrefix = "")
  public static class _Builder {

  }
}
