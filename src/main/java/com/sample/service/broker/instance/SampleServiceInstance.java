package com.sample.service.broker.instance;

import java.util.Map;

import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.CreateServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.instance.DeleteServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.DeleteServiceInstanceResponse;
import org.springframework.cloud.servicebroker.model.instance.GetServiceInstanceRequest;
import org.springframework.cloud.servicebroker.model.instance.GetServiceInstanceResponse;
import org.springframework.cloud.servicebroker.service.ServiceInstanceService;
import org.springframework.stereotype.Service;

import reactor.core.publisher.Mono;

@Service
public class SampleServiceInstance implements ServiceInstanceService {

	public Mono<CreateServiceInstanceResponse> createServiceInstance(CreateServiceInstanceRequest request) {
		String instanceId = request.getServiceInstanceId();
		String planId = request.getPlanId();
		Map<String, Object> parameters = request.getParameters();
		System.out.println("Workflow name: " + request.getServiceDefinitionId());
		System.out.println("Params: " + parameters);
		//call Submit workflow
		return Mono.just(CreateServiceInstanceResponse.builder().instanceExisted(true).build());
	}

	public Mono<DeleteServiceInstanceResponse> deleteServiceInstance(DeleteServiceInstanceRequest request) {
		return null;
	}
	
	public Mono<GetServiceInstanceResponse> getServiceInstance(GetServiceInstanceRequest request) {
		request.getServiceInstanceId();
		return null;
	}

}
