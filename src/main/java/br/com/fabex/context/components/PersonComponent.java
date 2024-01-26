package br.com.fabex.context.components;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PersonComponent {

    private final String name = "Person X";

    /* Not recommended
    @Autowired
    private PreferenceComponent preferenceComponent; */

    private final PreferenceComponent preferenceComponent;
    /* Work !
    public PersonComponent(PreferenceComponent pc) {
        this.preferenceComponent = pc;
    }*/

    /* Best practice! */
    public PersonComponent(@Qualifier("preference2") PreferenceComponent pc) {
        this.preferenceComponent = pc;
    }

    public String getName() {
        return name;
    }

    public PreferenceComponent getPreferenceComponent() {
        return preferenceComponent;
    }
}
