package mylab.notification;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class NotificationConfig {

    @Bean
    public EmailNotificationService emailNotificationService() {
        // 요구사항 값: smtp.gmail.com, 587
        return new EmailNotificationService("smtp.gmail.com", 587);
    }

    @Bean
    public SmsNotificationService smsNotificationService() {
        // 요구사항 값: SKT
        return new SmsNotificationService("SKT");
    }

    @Bean
    public NotificationManager notificationManager(EmailNotificationService emailNotificationService,
                                                   SmsNotificationService smsNotificationService) {
        return new NotificationManager(emailNotificationService, smsNotificationService);
    }
}
