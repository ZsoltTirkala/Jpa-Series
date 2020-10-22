package com.example.jpaseries;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@DataJpaTest
@RunWith(SpringRunner.class)
@ActiveProfiles("test")
class JpaseriesApplicationTests {

    @Test
    void contextLoads() {
    }

}
