package com.bestcode.employeeManagement.Configurations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;
import org.springframework.web.servlet.config.annotation.CorsRegistry;

import javax.persistence.EntityManager;
import javax.persistence.metamodel.EntityType;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Configuration
public class DataRestConfig implements RepositoryRestConfigurer {

    private EntityManager entityManager;

    @Autowired
    public DataRestConfig(EntityManager entityManager){
        this.entityManager = entityManager;
    }

    @Override
    public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config, CorsRegistry cors) {

        // Expose Entities ID
        Set<EntityType<?>> entities = entityManager.getMetamodel().getEntities();

        List<Class> entity = new ArrayList<>();

        for(EntityType temp : entities){
            entity.add(temp.getJavaType());
        }

    Class[] domainId = entity.toArray(new Class[0]);
        config.exposeIdsFor(domainId);
    }
}
