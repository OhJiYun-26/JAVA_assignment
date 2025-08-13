package mylab.notification;

public class NotificationManager {

    private final EmailNotificationService emailService;
    private final SmsNotificationService smsService;

    public NotificationManager(EmailNotificationService emailService,
                               SmsNotificationService smsService) {
        this.emailService = emailService;
        this.smsService = smsService;
    }

    public void sendNotificationByEmail(String message) {
        emailService.sendNotification(message);
    }

    public void sendNotificationBySms(String message) {
        smsService.sendNotification(message);
    }

    // 테스트 검증용 getter
    public EmailNotificationService getEmailService() {
        return emailService;
    }

    public SmsNotificationService getSmsService() {
        return smsService;
    }
}
