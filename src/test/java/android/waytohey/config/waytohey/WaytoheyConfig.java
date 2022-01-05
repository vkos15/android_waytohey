package android.waytohey.config.waytohey;

import org.aeonbits.owner.Config;

@Config.LoadPolicy(Config.LoadType.MERGE)
@Config.Sources({
        // "system:properties",
        "classpath:config/waytohey/prod.properties"
})

public interface WaytoheyConfig extends Config {

    @DefaultValue("dfg@ml.rootkid.ru")
    String exist_email();

    String user_active_login();

    String user_active_pass();

    String user_wrong_login();

    String user_wrong_pass();


}
