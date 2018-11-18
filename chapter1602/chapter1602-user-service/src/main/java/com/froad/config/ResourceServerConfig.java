package com.froad.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfiguration;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.token.TokenStore;

/**
 * @author ZHUZIHUI
 * @date 2018年10月29日
 */
@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter {

	Logger log = LoggerFactory.getLogger(ResourceServerConfiguration.class);

	@Value("${spring.application.name:user-service}")
	private String resouuceId;

	@Autowired
	private TokenStore tokenStore;

	@Override
	public void configure(ResourceServerSecurityConfigurer resources) throws Exception {
		log.info("Configuring ResourceServerSecurityConfigurer");
		resources.resourceId(resouuceId).tokenStore(tokenStore);
	}

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
			.authorizeRequests()
			.regexMatchers(".*swagger.*", ".*v2.*", ".*webjars.*", "/user/login.*", "/user/registry.*", "/user/test.*").permitAll()
			.antMatchers("/**").authenticated();
	}

}
