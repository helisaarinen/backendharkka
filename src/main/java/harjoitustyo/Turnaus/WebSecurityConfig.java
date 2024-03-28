package harjoitustyo.Turnaus;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import harjoitustyo.Turnaus.web.UserDetailServiceImpl;



@Configuration
@EnableMethodSecurity(securedEnabled = true) //enabloidaan metoditason security = TurnausControllerissa preAuthorize()
public class WebSecurityConfig {
	
	
	@Autowired
	private UserDetailServiceImpl userDetailsService; //turnaus.web paketissa
	
	
	@Bean
	public SecurityFilterChain configure(HttpSecurity http) throws Exception {

		http
		.authorizeHttpRequests(
				authorize -> authorize
			//	.requestMatchers(antMatcher("/css/**")).permitAll().anyRequest().authenticated())
				.requestMatchers("/etusivu", "main", "/css/**").permitAll() //Jos request päättyy näihin sivuihin, kaikilla oikeus mennä ilman kirjautumista
				.anyRequest().authenticated())

				.headers(headers -> 
				headers.frameOptions(frameOptions -> frameOptions // for h2console, jota ei tarvita, kun otetaan ulkoinen tietokanta käyttöön
						.disable()))
				.formLogin(
						formlogin -> formlogin
				//		.loginPage("/login") //JOs on tehnynä oma Login-sivu, tämä otetaan pois kommenteista
						.defaultSuccessUrl("/joukkuelistaus", true) //kun kirjautuminen on onnistunut, menee tälle sivulle
						.permitAll())
				//.logout(logout -> logout.permitAll()); //masiina hoitaa session sulkemisen, ei tarvi tehdä mitään
				.logout(logout -> logout.logoutSuccessUrl("/etusivu")
						.permitAll());
		return http.build();
	}

	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

}
