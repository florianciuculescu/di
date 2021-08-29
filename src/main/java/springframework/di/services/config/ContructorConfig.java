package springframework.di.services.config;


import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties("di")
public class ContructorConfig {

    private final String userName;
    private final String password;
    private final String jdbcUrl;

    public ContructorConfig(String userName, String password, String jdbcUrl) {
        this.userName = userName;
        this.password = password;
        this.jdbcUrl = jdbcUrl;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }
}
