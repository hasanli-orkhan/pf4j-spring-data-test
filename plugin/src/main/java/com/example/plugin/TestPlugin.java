package com.example.plugin;


import com.example.interfaces.PluginInterface;
import com.example.plugin.config.TestPluginConfig;
import lombok.extern.slf4j.Slf4j;
import org.pf4j.Extension;
import org.pf4j.PluginWrapper;
import org.pf4j.spring.SpringPlugin;
import org.pf4j.spring.SpringPluginManager;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

@Slf4j
public class TestPlugin extends SpringPlugin {

    public TestPlugin(PluginWrapper wrapper) {
        super(wrapper);
    }

    @Override
    public void start() {
        log.info("Plugin was started");
        super.start();
    }

    @Override
    public void stop() {
        log.info("Plugin was stopped");
        super.stop();
    }

    @Override
    protected ApplicationContext createApplicationContext() {
        ApplicationContext parentContext = ((SpringPluginManager) getWrapper().getPluginManager()).getApplicationContext();
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext();
        applicationContext.setClassLoader(getWrapper().getPluginClassLoader());
        applicationContext.setParent(parentContext);
        applicationContext.register(TestPluginConfig.class);
        applicationContext.refresh();

        return applicationContext;
    }
    @Extension(ordinal = 1)
    public static class SpringPlugin implements PluginInterface {

        @Override
        public String getName() {
            // todo implement this for reading from MANIFEST - https://manifests.jcabi.com/index.html
            return "example-plugin";
        }

        @Override
        public String getVersion() {
            return "1.0.0";
        }

        @Override
        public String getAuthor() {
            return "example";
        }
    }
}
