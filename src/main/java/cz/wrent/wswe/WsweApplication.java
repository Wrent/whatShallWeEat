package cz.wrent.wswe;

import cz.wrent.wswe.dataImport.trello.dto.Board;
import cz.wrent.wswe.dataImport.trello.service.TrelloImportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import reactor.core.publisher.Flux;

@SpringBootApplication
public class WsweApplication {

	@Autowired
	private TrelloImportService service;

	public static void main(String[] args) {
		SpringApplication.run(WsweApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner() {
		return args -> {
			Flux<Board> boards = service.getBoards();
			boards.toStream()
					.forEach(System.out::println);
		};
	}
}
