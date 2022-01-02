package android.waytohey.config;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        "system:properties",
        "classpath:config/${environment}.properties"
})

public interface ConfigBrowserStack extends Config {

    String user();

    String key();

    String url();

}
