package hello.servlet.web.springmvc.v1;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

// @Controller -> @Controller, @RequestMapping 으로 적어도 똑같이 동작
@Controller // 스프링이 자동으로 스프링 빈으로 등록한다.
// 스프링 MVC 에서 애노테이션 기반 컨트롤러로 인식한다,  RequestMappingHandlerMapping 에서 이건 핸들러 정보구나 하고 꺼낼 수 있다
public class SpringMemberFormControllerV1 {

    // RequestMappingHandlerMapping 은 스프링 중에서 @RequestMapping 또는 @Controller 가 클래스 레벨에 붙어 있는 경우에 매핑 정보로 인식한다.

    @RequestMapping("springmvc/v1/members/new-form") // 요청 정보를 매핑, 해당 URL 이 호출되면 이 메서드가 호출
    public ModelAndView process() {
        return new ModelAndView("new-form"); // 모델과 뷰 정보를 담아서 반환
    }


}
