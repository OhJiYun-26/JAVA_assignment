package mylab.notification;

public class SmsNotificationService implements NotificationService {

    private final String provider;

    public SmsNotificationService(String provider) {
        this.provider = provider;
    }

    @Override
    public void sendNotification(String message) {
        System.out.printf("[SMS] via %s -> %s%n", provider, message);
    }

    // 검증용 getter
    public String getProvider() {
        return provider;
    }
}
