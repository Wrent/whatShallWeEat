package cz.wrent.wswe.trelloDataImport.trello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class TrelloConfiguration {
    private final String trelloUrl;

  public TrelloConfiguration(@Value("${trello.url.prefix}") String trelloUrl) {
        this.trelloUrl = trelloUrl;
    }

    @Bean
    public WebClient trelloWebClient() {
        return WebClient.create(trelloUrl);
    }
}
