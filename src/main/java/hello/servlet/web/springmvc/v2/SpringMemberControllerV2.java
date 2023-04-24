package hello.servlet.web.springmvc.v2;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping ("springmvc/v2/members")
public class SpringMemberControllerV2 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @RequestMapping("/new-form") // 요청 정보를 매핑, 해당 URL 이 호출되면 이 메서드가 호출
    public ModelAndView newForm() {
        return new ModelAndView("new-form"); // 모델과 뷰 정보를 담아서 반환
    }

    @RequestMapping
    public ModelAndView members() {
        List<Member> members = memberRepository.findAll();
        ModelAndView modelAndView = new ModelAndView("members");
//        modelview.getModel().put("members", members);
        modelAndView.addObject("members", members);

        return modelAndView;
    }

    @RequestMapping("/save")
    public ModelAndView save(HttpServletRequest request, HttpServletResponse response) {
        // frontController 에서 해결
        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        // frontController 에서 해결
        ModelAndView modelAndView = new ModelAndView("save-result");
//        modelAndView.getModel().put("member", member);
        modelAndView.addObject("member", member);
        return modelAndView;
    }

}
