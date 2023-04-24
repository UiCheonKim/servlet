package hello.servlet.web.servletmvc;

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
@WebServlet(name = "mvcMemberFormServlet", urlPatterns = "/servlet-mvc/members/new-form")
public class MvcMemberFormServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String viewPath = "/WEB-INF/views/new-form.jsp";
        // controller 에서 view 로 이동할 때 사용
        // viewPath 로 이동할꺼야!
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);
        // servlet 에서 jsp 호출 (서버끼리 내부에서 호출 제어권을 넘겨주는 것)
        dispatcher.forward(request, response);
    }
}
