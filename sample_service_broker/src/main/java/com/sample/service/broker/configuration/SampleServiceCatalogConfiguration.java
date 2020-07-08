package com.sample.service.broker.configuration;

import java.util.HashMap;
import java.util.Map;

import org.springframework.cloud.servicebroker.model.catalog.Catalog;
import org.springframework.cloud.servicebroker.model.catalog.MethodSchema;
import org.springframework.cloud.servicebroker.model.catalog.Plan;
import org.springframework.cloud.servicebroker.model.catalog.Schemas;
import org.springframework.cloud.servicebroker.model.catalog.ServiceDefinition;
import org.springframework.cloud.servicebroker.model.catalog.ServiceInstanceSchema;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SampleServiceCatalogConfiguration {

	@Bean
	public Catalog catalog() {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("$schema", "http://json-schema.org/draft-04/schema#");
		parameters.put("type", "object");
		Map<String, String> paramDefinition = new HashMap<String, String>();
		paramDefinition.put("title", "User name");
		paramDefinition.put("description", "Type the user name");
		paramDefinition.put("type", "string");
		Map<String, Object> property = new HashMap<String, Object>();
		property.put("username", paramDefinition);
		parameters.put("properties", property);

		MethodSchema createMethodSchema = MethodSchema.builder().parameters(parameters).build();
		
		Plan plan = Plan.builder().id("appviewx-service-plan-id-1")
				.name("standard")
				.schemas(Schemas.builder()
						.serviceInstanceSchema(
								ServiceInstanceSchema.builder().createMethodSchema(createMethodSchema).build())
						.build())
				.description("Standard appviewx service plan").build();
		
		ServiceDefinition serviceDefinition = ServiceDefinition.builder().id("avx-email-service")
				.name("avx-email-service").description("appviewx mailing service").plans(plan).bindable(false).build();
		return Catalog.builder().serviceDefinitions(serviceDefinition).build();
	}
}
