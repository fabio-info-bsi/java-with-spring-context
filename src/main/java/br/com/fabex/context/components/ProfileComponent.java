package br.com.fabex.context.components;

import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
@Lazy
public class ProfileComponent {

    private final PersonComponent personComponent;

    public ProfileComponent(PersonComponent personComponent) {
        System.out.println("[ProfileComponent] Initializing ... ");
        this.personComponent = personComponent;
    }

    public PersonComponent getPersonComponent() {
        return personComponent;
    }
}
