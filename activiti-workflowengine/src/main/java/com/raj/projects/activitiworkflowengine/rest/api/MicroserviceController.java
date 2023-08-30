package com.raj.projects.activitiworkflowengine.rest.api;
import org.activiti.engine.RuntimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/orders")
public class MicroserviceController {

    private final RuntimeService runtimeService;

    @Autowired
    public MicroserviceController(RuntimeService runtimeService) {
        this.runtimeService = runtimeService;
    }

    @PostMapping
    public void createOrder() {
        runtimeService.startProcessInstanceByKey("microservice-orchestrator");
        System.out.println("Order process started!");
    }
}
