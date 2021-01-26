package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import org.junit.Before;

public class BeforeScenario extends SpringTest {

    @Before
    public void beforeScenario() {
        sharedStorage.clear();
    }
}
