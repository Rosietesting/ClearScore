package com.clearScore.test.scenario;


import com.clearScore.rest.LoginTasks;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;

/**
 * This class serves as scenario generator to register the tasks in the project
 * In this case I only logged loginTask
 */
public class ScenarioGenerator {

    @Inject
    private LoginTasks loginTasks;

    private static final Logger LOGGER = LoggerFactory.getLogger(ScenarioGenerator.class);
    public LoginTasks loginTasksBuilder() {
        return loginTasks;
    }


    private ExecutionType executionType;

    public ScenarioGenerator(ExecutionType executionType) {
        this.executionType = executionType;
        LOGGER.info("Constructed ScenarioGenerator for {} execution", executionType.name());
    }

    public ExecutionType getExecutionType() {
        return executionType;
    }


    public enum ExecutionType {
        REST,
        IN_MEMORY
    }




}


