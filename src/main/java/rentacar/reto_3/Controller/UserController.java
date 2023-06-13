package rentacar.reto_3.Controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.Map;

@RestController
public class UserController {
    @GetMapping("/user") //Vamos a traer la información del usuario que se registra con GitHub mediante Oauth2
    public Map <String, Object> user (@AuthenticationPrincipal OAuth2User principal){
        System.out.println("Datos del usuario\n"+ principal.getAttributes()); //Nos imprime todos los atributos
        return Collections.singletonMap("name",principal.getAttribute("name"));
    }

}
