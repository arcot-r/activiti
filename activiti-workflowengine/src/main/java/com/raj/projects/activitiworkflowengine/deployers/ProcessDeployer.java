package com.raj.projects.activitiworkflowengine.deployers;
import org.activiti.engine.RepositoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class ProcessDeployer implements CommandLineRunner {

	@Autowired
    private final RepositoryService repositoryService;

    @Autowired
    public ProcessDeployer(RepositoryService repositoryService) {
        this.repositoryService = repositoryService;
    }

    @Override
    public void run(String... args) throws Exception {
        repositoryService.createDeployment()
                .addClasspathResource("microservice-orchestrator.bpmn")
                .deploy();

        System.out.println("Process deployed!");
    }
}
