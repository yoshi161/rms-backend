package com.mitrais.bootcamp.rms.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration;

@Configuration
public class RestRepositoriesConfig extends RepositoryRestMvcConfiguration {
    /*
     * (non-Javadoc)
     * 
     * @see org.springframework.data.rest.webmvc.config.RepositoryRestMvcConfiguration
     * #configureRepositoryRestConfiguration(org.springframework.data.rest.core.
     * config.RepositoryRestConfiguration)
     */

/*    protected void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
        super.configureRepositoryRestConfiguration(config);
        try {

            config.setBaseUri(new URI("/api"));

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }*/
	

}
