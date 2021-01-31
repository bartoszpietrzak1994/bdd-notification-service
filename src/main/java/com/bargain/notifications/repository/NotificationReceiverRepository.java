package com.bargain.notifications.repository;

import com.bargain.notifications.model.NotificationReceiver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationReceiverRepository extends JpaRepository<NotificationReceiver, Long> {

    NotificationReceiver getOneByUserReference(String userReference);
}
