package net.javaguides.springboot;

import net.javaguides.springboot.model.PlayerDetails;
import net.javaguides.springboot.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringbootBackendApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootBackendApplication.class, args);
	}

	@Autowired
	private PlayerRepository playerRepository;

	@Override
	public void run(String... args) throws Exception {

		PlayerDetails user = new PlayerDetails();
		user.setPlayerName("Arkam");
		user.setPlayerAge("26");
		user.setPlayerBorn("1996/04/03");
		user.setPlayerCountry("Sri lanka");
		user.setPlayerHeight("6");
		user.setPlayerPosition("Defend");
		user.setPlayerApps("59");
		user.setPlayerPlayedMinutes("256");
		user.setPlayerGoals("56");
		user.setPlayerAssist("45");
		user.setPlayerYellowCard("28");
		user.setPlayerRedCard("12");
		user.setPlayerSpg("46%");
		user.setPlayerPs("33");
		user.setPlayerArialWon("44");
		user.setPlayerMom("23");
		user.setPlayerPerformance("Excellent");
		playerRepository.save(user);
	}
}
