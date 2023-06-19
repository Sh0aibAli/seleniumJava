package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import utilities.BaseFunctions;

public class Hooks {
    static int flow=0;
    @Before
    public void before(){
        flow=0;
    }

    @After
    public void after(Scenario scenario){
        if (scenario.isFailed()){
            System.out.println("failing step--"+scenario.getName());
            final byte[] screenshot = BaseFunctions.takeScreenshot();
            scenario.attach(screenshot,"image/png",scenario.getName()+".png");
        }
        BaseFunctions.closeSession();
    }
}
