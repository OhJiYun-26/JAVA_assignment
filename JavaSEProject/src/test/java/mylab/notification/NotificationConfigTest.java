package mylab.notification;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

@SpringJUnitConfig(NotificationConfig.class) 
class NotificationConfigTest {

    @Autowired
    private NotificationManager notificationManager;

    @Test
    void test_빈_주입_및_설정값_검증() {
        // 1) NotificationManager 주입 검증
        assertNotNull(notificationManager, "NotificationManager 가 주입되어야 합니다.");

        // 2) 이메일 서비스 검증
        EmailNotificationService emailService = notificationManager.getEmailService();
        assertNotNull(emailService, "EmailNotificationService 가 주입되어야 합니다.");
        assertEquals("smtp.gmail.com", emailService.getSmtpServer(), "SMTP 서버 주소가 일치해야 합니다.");
        assertEquals(587, emailService.getPort(), "SMTP 포트가 587 이어야 합니다.");

        // 3) SMS 서비스 검증
        SmsNotificationService smsService = notificationManager.getSmsService();
        assertNotNull(smsService, "SmsNotificationService 가 주입되어야 합니다.");
        assertEquals("SKT", smsService.getProvider(), "SMS Provider 가 'SKT' 이어야 합니다.");

        // 4) 메서드 실행(콘솔 출력 확인)
        notificationManager.sendNotificationByEmail("테스트 이메일");
        notificationManager.sendNotificationBySms("테스트 SMS");
    }
}
