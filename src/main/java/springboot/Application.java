package springboot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //스프링부트의 자동설정, 스프링빈읽기와 생성을 모두 자동으로 설정
//이 애너테이션으로 부터 설정을 읽어가기 때문에 이클래스는 항상 프로젝트의 최상단에 위치해야 합니다
public class Application { //앞으로 만들 클래스의 메인 클래스
    public static void main(String[] args){
        SpringApplication.run(Application.class, args); //run 으로 인해 내장WAS를 실행함
    }
}
