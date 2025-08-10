package mylab.library.control;

import mylab.library.entity.Library;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LibraryConfig {
    @Bean
    public Library library() {
        return new Library("중앙 도서관"); // 샘플 런에서 쓰는 이름
    }
}
