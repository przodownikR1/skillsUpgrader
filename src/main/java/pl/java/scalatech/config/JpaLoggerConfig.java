package pl.java.scalatech.config;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.jdbc.DataSourceProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

import static net.sf.log4jdbc.tools.LoggingType.SINGLE_LINE;

import net.sf.log4jdbc.Log4jdbcProxyDataSource;
import net.sf.log4jdbc.tools.Log4JdbcCustomFormatter;

@Configuration
@Slf4j
@Profile("logger")
class JpaLoggerConfig {

	private static final String SQL = "SQL:\r";

	public JpaLoggerConfig() {
	 log.info("++++ JpaLoggerConfig....");
	}
	@Bean
	@Primary
	@Profile("logger")
	public DataSource dataSource(DataSource primaryDataSource) {
		log.info("+++++ dataSource init ....");
		Log4jdbcProxyDataSource dataSource = new Log4jdbcProxyDataSource(primaryDataSource);
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

	@Autowired
	DataSourceProperties properties;
	DataSource dataSource;


	@Bean(destroyMethod = "close")
	DataSource realDataSource() {
		DataSourceBuilder factory = DataSourceBuilder
				.create(this.properties.getClassLoader())
				.url(this.properties.getUrl())
				.username(this.properties.getUsername())
				.password(this.properties.getPassword());
		this.dataSource = factory.build();
		return this.dataSource;
	}



}