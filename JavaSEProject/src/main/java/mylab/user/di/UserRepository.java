package mylab.user.di;

import org.springframework.stereotype.Component;

@Component
public class UserRepository {

    private final String dbType = "MySQL"; // 테스트에서 검증 대상

    public String getDbType() {
        return dbType;
    }

    public void save(User user) {
        // 실제로는 DB 저장 로직이 들어가겠죠.
        System.out.println("[UserRepository] Saved user: " + user.getUsername());
    }
}
