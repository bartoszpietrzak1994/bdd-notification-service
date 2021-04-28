package com.bargain.notifications;

import com.bargain.notifications.common.service.SharedStorage;
import com.bargain.notifications.notification.sender.gateway.EmailGateway;
import com.bargain.notifications.notification.sender.gateway.SmsGateway;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.cucumber.spring.CucumberContextConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;

@CucumberContextConfiguration
@SpringBootTest
@ActiveProfiles({"test"})
@AutoConfigureMockMvc
public class SpringTest {

    @Autowired
    protected SharedStorage sharedStorage;

    @Autowired
    protected ObjectMapper objectMapper;

    @Autowired
    protected MockMvc mockMvc;

    @Autowired
    @MockBean
    protected EmailGateway emailGateway;

    @Autowired
    @MockBean
    protected SmsGateway smsGateway;
}
