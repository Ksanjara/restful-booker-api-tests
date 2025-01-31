package config;

import org.aeonbits.owner.Config;

@Config.Sources("classpath:api.properties")
public interface ApiConfig extends Config {
    @Key("baseUri")
    String baseApiUri();

    @Key("login")
    String username();

    @Key("password")
    String password();

}
