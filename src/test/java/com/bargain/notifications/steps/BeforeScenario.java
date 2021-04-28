package com.bargain.notifications.steps;

import com.bargain.notifications.SpringTest;
import com.bargain.notifications.channel.ChannelRepository;
import com.bargain.notifications.notification.receiver.NotificationReceiverRepository;
import io.cucumber.java.Before;
import org.springframework.beans.factory.annotation.Autowired;

import static org.mockito.Mockito.reset;

public class BeforeScenario extends SpringTest {

    @Autowired
    private NotificationReceiverRepository notificationReceiverRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Before
    public void beforeScenario() {
        reset(emailGateway);
        reset(smsGateway);

        channelRepository.deleteAll();
        notificationReceiverRepository.deleteAll();
        sharedStorage.clear();
    }
}
