package com.francis.resttemplate;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.io.Serializable;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ResttemplateApplicationTests {

    static final String URI = "http://127.0.0.1:8080/api/web/user/login";

    @Resource
    RestTemplate restTemplate;

    @Test
    public void test() throws ClassNotFoundException {
        Users user = new Users();
        user.setUserName("userName");
        user.setPassword("password");
        ResponseEntity<Results> resultsResponseEntity = restTemplate.postForEntity(URI,
                user, Results.class);
        Results body = resultsResponseEntity.getBody();
        System.out.println(body.getResult());

    }

    static class Users implements Serializable {
        private String userName;
        private String password;

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getPassword() {
            return password;
        }

        public void setPassword(String password) {
            this.password = password;
        }
    }
    static class Results implements Serializable{
        private Integer result;

        private String content;

        public Integer getResult() {
            return result;
        }

        public void setResult(Integer result) {
            this.result = result;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }
    }

    @Test
    public void contextLoads() {
    }

}
