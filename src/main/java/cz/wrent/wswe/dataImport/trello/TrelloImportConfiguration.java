package cz.wrent.wswe.dataImport.trello;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;


@Configuration
public class TrelloImportConfiguration {
    private final String trelloUrl;

    public TrelloImportConfiguration(@Value("${trello.url}") String trelloUrl) {
        this.trelloUrl = trelloUrl;
    }

    @Bean
    public WebClient trelloWebClient() {
        return WebClient.create(trelloUrl);
    }
}
