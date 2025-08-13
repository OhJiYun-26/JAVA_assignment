package mylab.user.di;

import org.springframework.stereotype.Component;

@Component
public class SecurityService {

    // 아주 단순한 인증 예시
    public boolean authenticate(String username, String password) {
        // 실제로는 비밀번호 해시/검증 로직 등이 들어갈 것
        return username != null && !username.isEmpty()
                && password != null && !password.isEmpty();
    }
}
