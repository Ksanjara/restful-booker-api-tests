package config;

import org.aeonbits.owner.ConfigFactory;

public class ProjectConfigCreator {
    public static ApiConfig config = ConfigFactory.create(ApiConfig.class, System.getProperties());
}
