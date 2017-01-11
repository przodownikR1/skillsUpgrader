package pl.java.scalatech.config;

import static net.sf.log4jdbc.tools.LoggingType.SINGLE_LINE;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import lombok.extern.slf4j.Slf4j;
import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;

@Configuration
@Slf4j
@Profile("logger")
public class JpaLoggerConfig {
    
    private static final String SQL = "SQL:\r";

    public JpaLoggerConfig() {
     log.info("++++ JpaLoggerConfig....");
    }
    @Bean
    @Primary
    @Profile("logger")
    @DependsOn("hikariDataSource")
    public DataSource dataSource(DataSource hikariDataSource) {
        log.info("+++++ dataSource init ....");
        Log4jdbcProxyDataSource dataSource = new Log4jdbcProxyDataSource(hikariDataSource);
        dataSource.setLogFormatter(logFormater());
        return dataSource;
    }

    @Bean
    public Log4JdbcCustomFormatter logFormater() {
        Log4JdbcCustomFormatter formatter = new Log4JdbcCustomFormatter();
        formatter.setLoggingType(SINGLE_LINE);
        formatter.setSqlPrefix(SQL);
        return formatter;
    }

}