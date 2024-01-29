package br.com.fabex.context;


import br.com.fabex.context.components.*;
import br.com.fabex.context.config.ProjectConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.function.Supplier;

public class SpringContextApplication {

    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);

        // Annotation @Component
        UtilAnnotationComponent uac = context.getBean(UtilAnnotationComponent.class);
        System.out.println(uac.getName());

        // Method wit @Bean & @Primary
        UtilManualComponent umc = context.getBean(UtilManualComponent.class);
        System.out.println(umc.name());

        UtilManualComponent alternative = context.getBean("utilManualComponentAlternative", UtilManualComponent.class);
        System.out.println(alternative.name());

        // Programatically
        UtilManualComponent component = new UtilManualComponent("Programatilly UtilManualComponent");
        Supplier<UtilManualComponent> supplier = () -> component;

        context.registerBean("programattilly", UtilManualComponent.class, supplier);

        UtilManualComponent programattilly = context.getBean("programattilly", UtilManualComponent.class);
        System.out.println(programattilly.name());

        PersonComponent personComponent = context.getBean(PersonComponent.class);
        System.out.println(personComponent.getName());
        System.out.println(personComponent.getPreferenceComponent());

        /* Lazy Component */
        ProfileComponent profileComponent = context.getBean(ProfileComponent.class);
        System.out.println("profileComponent.getPersonComponent() == personComponent: "+
                (profileComponent.getPersonComponent() == personComponent));

        /* SCOPE_PROTOTYPE (new instance by request) */
        BallComponent ballComponent = context.getBean("soccerBall",BallComponent.class);
        BallComponent ballComponent2 = context.getBean("soccerBall",BallComponent.class);
        System.out.println("ballComponent == ballComponent2: "+
                (ballComponent == ballComponent2) );

        BallComponent ballComponent3 = context.getBean("basketball",BallComponent.class);
        System.out.println("ballComponent(SCOPE_PROTOTYPE) == ballComponent3(Singleton): "+
                (ballComponent == ballComponent3) );
    }

}
