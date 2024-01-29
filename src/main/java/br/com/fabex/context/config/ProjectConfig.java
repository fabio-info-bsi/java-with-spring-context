package br.com.fabex.context.config;

import br.com.fabex.context.components.BallComponent;
import br.com.fabex.context.components.PreferenceComponent;
import br.com.fabex.context.components.UtilManualComponent;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan(basePackages = "br.com.fabex.context.components")
public class ProjectConfig {

    @Bean
    @Primary
    public UtilManualComponent utilManualComponent(){
        return new UtilManualComponent("UtilManualComponent");
    }

    @Bean("utilManualComponentAlternative")
    public UtilManualComponent utilManualComponentAlternative(){
        return new UtilManualComponent("UtilManualAlternativeComponent");
    }

    @Bean("preference")
    @Primary
    public PreferenceComponent preference(){
        return new PreferenceComponent("Backend", "pt_BR", 1);
    }

    @Bean("preference2")
    public PreferenceComponent preference2(){
        return new PreferenceComponent("FullStack", "pt_PT", 2);
    }

    @Bean("soccerBall")
    @Scope(BeanDefinition.SCOPE_PROTOTYPE) /* Always give a new instance wwhen request! */
    public BallComponent ballSoccer(){
        return new BallComponent("Jabulane", "soccer");
    }

    @Bean("basketball")
    public BallComponent ballBasket(){
        return new BallComponent("Laranjinha", "Basketball");
    }
}
