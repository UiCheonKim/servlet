package hello.servlet.web.springmvc.v3;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping ("springmvc/v3/members")
public class SpringMemberControllerV3 {

    private MemberRepository memberRepository = MemberRepository.getInstance();

//    @RequestMapping(value = "/new-form", method = RequestMethod.GET) // 요청 정보를 매핑, 해당 URL 이 호출되면 이 메서드가 호출
    @GetMapping("/new-form")
    public String newForm() {
        return "new-form"; // ModelAndView 로 반환해도 되고, 인터페이스로 고정되어있어 유연하게 되어잇음 문자로 반환해도 가능
        // view 이름인줄 알고 process 가 진행됨
//        return new ModelAndView("new-form"); // 모델과 뷰 정보를 담아서 반환
    }

//    @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String members(Model model) {
        List<Member> members = memberRepository.findAll();
        model.addAttribute("members", members);
//        ModelAndView modelAndView = new ModelAndView("members");
////        modelview.getModel().put("members", members);
//        modelAndView.addObject("members", members);

        return "members";
    }

//    @RequestMapping(value = "/save", method = RequestMethod.POST)
    @RequestMapping("/save")
    public String save(
            @RequestParam("username") String username,
            @RequestParam("age") int age,
            Model model) {
        // frontController 에서 해결
//        String username = request.getParameter("username");
//        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);

        model.addAttribute("member", member);

        // frontController 에서 해결
//        ModelAndView modelAndView = new ModelAndView("save-result");
////        modelAndView.getModel().put("member", member);
//        modelAndView.addObject("member", member);

        return "save-result";
    }

}
