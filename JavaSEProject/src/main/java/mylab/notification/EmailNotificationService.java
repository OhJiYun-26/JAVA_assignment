package mylab.notification;

public class EmailNotificationService implements NotificationService {

    private final String smtpServer;
    private final int port;

    public EmailNotificationService(String smtpServer, int port) {
        this.smtpServer = smtpServer;
        this.port = port;
    }

    @Override
    public void sendNotification(String message) {
        System.out.printf("[EMAIL] via %s:%d -> %s%n", smtpServer, port, message);
    }

    // 검증용 getter
    public String getSmtpServer() {
        return smtpServer;
    }

    public int getPort() {
        return port;
    }
}
