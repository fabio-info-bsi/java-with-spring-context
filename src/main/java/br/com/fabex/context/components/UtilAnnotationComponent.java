package br.com.fabex.context.components;

import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Component;

@Component
public class UtilAnnotationComponent {

    private String name;

    @PostConstruct
    public void postConstruct() {
        System.out.println("Pos construct UtilComponent ... ");
        this.name = "UtilAnnotationComponent";
    }

    public final String getName() {
        return this.name;
    }
}
