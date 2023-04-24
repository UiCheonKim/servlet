package hello.servlet.web.frontcontroller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Map;

public class MyView {

    private String viewPath;

    public MyView(String viewPath) {
        this.viewPath = viewPath;
    }

    public void render(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher(viewPath);// view 로 이동할 때 사용
        dispatcher.forward(request, response); // servlet   에서 jsp 호출 (서버끼리 내부에서 호출 제어권을 넘겨주는 것)
    }

    public void render(Map<String, Object> model, HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        modelToRequestAttribute(model, request); // model 값을 requestAttribute 로 바꾼다.
        RequestDispatcher requestDispatcher = request.getRequestDispatcher(viewPath);
        requestDispatcher.forward(request,response);
    }

    private static void modelToRequestAttribute(Map<String, Object> model, HttpServletRequest request) {
        // jsp 는 setAttribute 에서 값을 꺼내기 때문에 여기에다 집어넣어야함.
        model.forEach((key, value) -> request.setAttribute(key, value));
    }
}
