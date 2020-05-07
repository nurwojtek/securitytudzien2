package pl.com.nur.securitytudzien2.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.com.nur.securitytudzien2.service.AuthenticationService;

import java.security.Principal;

@RestController
public class SecorityTestApi {

    AuthenticationService authenticationService;

    public SecorityTestApi(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @GetMapping("/")
    public String forAllStart(Principal principal){
        return "Strona startowa dla wszystkich";
    }

    @GetMapping("/forAll")
    public String forAll(Principal principal){
        if (principal == null)
            return "Cześć nieznajomy";
        return "Cześć " + principal.getName() + authenticationService.authenticationCount(principal);
    }

    @GetMapping("/forAdmin")
    public String forAdmin(Principal principal){
        return "Cześć admin " + principal.getName() + authenticationService.authenticationCount(principal);
    }

    @GetMapping("/forUser")
    public String forUser(Principal principal){
        return "Cześć user " + principal.getName() + authenticationService.authenticationCount(principal);
    }

    @GetMapping("/papa")
    public String forAll(){
        return "Papa";
    }

}
