package rentacar.reto_3.Security;

import org.springframework.http.HttpStatus;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.HttpStatusEntryPoint;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SecurityAdapter extends WebSecurityConfigurerAdapter {
    @Override
    protected void configure(HttpSecurity Http) throws Exception{ //** significa que todo lo que vaya delante es permitido
        Http.authorizeHttpRequests(
                a-> a.antMatchers("/","/error","/webjars/**","/api/**").permitAll().anyRequest().authenticated()
        ).exceptionHandling(
                e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.FORBIDDEN))//403 en caso de que el usuario intente hacer otra operación fuera de estos dominiuios
        ).oauth2Login().defaultSuccessUrl("/HomePage.html", true); //En caso de logearse bien, lo redireccionamos a una url

        Http.cors().and().csrf().disable();
    }


}
