package com.clearScore.test.scenario;

import com.clearScore.test.config.RestItConfig;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * This is the vase scenario that specifies that the test is going to run with SpringJunit
 * It also specifies where the configuration context is
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RestItConfig.class})
public class BaseScenario {



}
