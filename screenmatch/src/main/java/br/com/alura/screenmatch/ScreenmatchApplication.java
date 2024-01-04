package br.com.alura.screenmatch;

import br.com.alura.screenmatch.principal.Principal;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ScreenmatchApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(ScreenmatchApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Principal principal = new Principal();
        principal.exibirMenu();

//		var json1 = consumoAPI.obterDados("https://api.waifu.pics/sfw/waifu");
//		System.out.println(json1);


    }
}
