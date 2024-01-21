package com.example.app.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.annotation.PreDestroy;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;



@Configuration
public class PluginConfig implements BeanFactoryAware {

    private final SpringPluginManager pluginManager;
    private final ApplicationContext applicationContext;
    private final ObjectMapper objectMapper;
    private BeanFactory beanFactory;

    @Autowired
    public PluginConfig(SpringPluginManager pm, ApplicationContext applicationContext) {
        this.pluginManager = pm;
        this.applicationContext = applicationContext;
        this.objectMapper = new ObjectMapper();
    }

    @Override
    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        this.beanFactory = beanFactory;
    }

//    @Bean
//    @DependsOn("pluginManager")
//    public RouterFunction<?> pluginEndpoints(PluginManager pm) {
//        registerMvcEndpoints(pm);
//        return getReactiveRoutes(pm);
//    }

//    private RouterFunction<?> getReactiveRoutes(PluginManager pm) {
//        RouterFunction<?> base = baseRoot(pm);
//        RouterFunction<?> routes = pm.getExtensions(PluginInterface.class).stream()
//                .flatMap(g -> g.reactiveRoutes().stream())
//                .map(r-> (RouterFunction<ServerResponse>)r)
//                .reduce((o,r )-> (RouterFunction<ServerResponse>) o.andOther(r))
//                .orElse(null);
//        return routes == null ? base : base.andOther(routes);
//    }

//    private RouterFunction<?> baseRoot(PluginManager pm) {
//        return route(GET("/plugins"),
//                req -> ServerResponse.ok().body(Mono.just(pluginNamesMono(pm)), String.class));
//    }

//    private String pluginNamesMono(PluginManager pm) {
//        List<String> identityList = pm.getExtensions(PluginInterface.class).stream()
//                .map(g-> g.getClass().getName() + ": " + g.identify())
//                .collect(Collectors.toList());
//        try {
//            return objectMapper.writeValueAsString(identityList);
//        } catch (JsonProcessingException e) {
//            return "[]";
//        }
//    }
//
//
//    private void registerMvcEndpoints(PluginManager pm) {
//        pm.getExtensions(PluginInterface.class).stream()
//                .flatMap(g -> g.mvcControllers().stream())
//                .forEach(r -> ((ConfigurableBeanFactory) beanFactory)
//                        .registerSingleton(r.getClass().getName(), r));
//        applicationContext
//                .getBeansOfType(RequestMappingHandlerMapping.class)
//                .forEach((k, v) -> v.afterPropertiesSet());
//    }


    @PreDestroy
    public void cleanup() {
        pluginManager.stopPlugins();
    }

}