package pl.com.nur.securitytudzien2.service;

import org.springframework.context.event.EventListener;
import org.springframework.security.authentication.event.AuthenticationSuccessEvent;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Service;

import java.security.Principal;

@Service
public class AuthenticationService {

    PeopleList peopleList;

    public AuthenticationService(PeopleList peopleList) {
        this.peopleList = peopleList;
    }

    @EventListener
    public void authenticationSuccessEvent(AuthenticationSuccessEvent event) {
        String user = ((User)event.getAuthentication().getPrincipal()).getUsername();
        for (int i=0; i<peopleList.getPeopleList().size();i++) {
            if (peopleList.getPeopleList().get(i).getNick().equals(user)) {
                peopleList.getPeopleList().get(i).setCountLog();
            }
        }
    }

    public String authenticationCount(Principal principal){
        for (int i=0; i<peopleList.getPeopleList().size();i++){
            if(peopleList.getPeopleList().get(i).getNick().equals(principal.getName())){
                return " ilosc logowań = " + peopleList.getPeopleList().get(i).getCountLog();
            }
        }
        return "nie ma Cię, coś poszło nie tak";
    }
}
