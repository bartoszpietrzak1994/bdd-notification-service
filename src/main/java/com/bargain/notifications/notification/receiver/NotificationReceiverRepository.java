package com.bargain.notifications.notification.receiver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationReceiverRepository extends JpaRepository<NotificationReceiver, Long> {

    NotificationReceiver getOneByUserReference(String userReference);
}
