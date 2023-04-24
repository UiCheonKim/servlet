package hello.servlet.web.servletmvc;

import hello.servlet.domain.member.Member;
import hello.servlet.domain.member.MemberRepository;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

/*
    서블릿을 등록하기 위해 @WebServlet 어노테이션을 추가한다.

    - name : 서블릿 이름
    - urlPatterns: URL 매핑
 */
@WebServlet(name = "mvcMemberSaveServlet", urlPatterns = "/servlet-mvc/members/save")
public class MvcMemberSaveServlet extends HttpServlet {

    private MemberRepository memberRepository = MemberRepository.getInstance();

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String username = request.getParameter("username");
        int age = Integer.parseInt(request.getParameter("age"));

        Member member = new Member(username, age);
        memberRepository.save(member);
        //////////////////////////// -- 파라미터 받고 실제 비즈니스 로직 호출하고

        // request 내부 객체에 잇는 저장소
        // Model에 데이터를 보관한다. "member"가 key가 되고 member가 value가 된다.
        request.setAttribute("member", member);
        //////////////////////////// -- Model에 데이터 담고

        String viewPath = "/WEB-INF/views/save-result.jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        dispatcher.forward(request, response);
        //////////////////////////// -- view에 던지기

        ////////////////////////////////////////////// -- 전체적으로 봤을때 controller 역할 충실히 하고 잇음

    }
}