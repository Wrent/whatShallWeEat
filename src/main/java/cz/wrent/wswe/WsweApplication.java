package cz.wrent.wswe;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class WsweApplication {
//
//  @Autowired
//  private TrelloService service;

  public static void main(String[] args) {
    SpringApplication.run(WsweApplication.class, args);
  }

//  @Bean
//  public CommandLineRunner commandLineRunner() {
//    return args -> {
//      Flux<Board> boards = service.getBoards();
//      boards.toStream()
//          .forEach(System.out::println);
//
//      service.getCardsOnBoard("5a524b82e5ab404848dd6209")
//          .toStream()
//          .forEach(System.out::println);
//    };
//  }
}
