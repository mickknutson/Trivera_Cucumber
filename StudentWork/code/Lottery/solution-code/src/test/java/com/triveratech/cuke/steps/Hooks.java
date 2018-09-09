package com.triveratech.cuke.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks {

    @Before(order = 0)
    public void beforeScenarioStart(){
        System.out.println("0 -----------------Start of Scenario-----------------");
    }

    @Before(order = 1)
    public void beforeScenario(){
        System.out.println("1 *** Start Kafka Server and clear stream ***");
    }


    @After(order = 0)
    public void afterScenarioFinish(){
        System.out.println("-----------------End of Scenario-----------------");
    }

    @After(order = 1)
    public void afterScenario(){
        System.out.println("*** clear Kafka stream ***");
    }

} // The End...
