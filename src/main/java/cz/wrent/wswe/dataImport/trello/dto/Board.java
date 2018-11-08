package cz.wrent.wswe.dataImport.trello.dto;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonPOJOBuilder;
import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "_Builder")
@JsonDeserialize(builder = Board._Builder.class)
public class Board {
    private final String id;
    private final String name;

    @JsonPOJOBuilder(withPrefix = "")
    public static class _Builder {
    }
}
