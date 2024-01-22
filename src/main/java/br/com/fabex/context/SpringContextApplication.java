package br.com.fabex.context;


import br.com.fabex.context.components.UtilManualComponent;
import br.com.fabex.context.config.ProjectConfig;
import br.com.fabex.context.components.UtilAnnotationComponent;
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

    }

}
