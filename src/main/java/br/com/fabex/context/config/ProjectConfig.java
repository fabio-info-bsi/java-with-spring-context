package br.com.fabex.context.config;

import br.com.fabex.context.components.PreferenceComponent;
import br.com.fabex.context.components.UtilManualComponent;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
}
