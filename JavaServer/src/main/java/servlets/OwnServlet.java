package servlets;

import pageGen.PageGenerator;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OwnServlet extends HttpServlet {

    private static Map<String, Object> pageVar(HttpServletRequest request) {
        Map<String, Object> var = new HashMap<>();
        var.put("path", request.getPathInfo());
        var.put("method", request.getMethod());
        var.put("message", "You not have new message!");
        return var;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, Object> var = pageVar(request);
        response.getWriter().println(PageGenerator.inst().getPage("index.html", var));
        response.setContentType("text/html;charset=utf-8");
        response.setStatus(HttpServletResponse.SC_OK);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        Map<String, Object> var = pageVar(request);
        String message = request.getParameter("message");
        if (!message.equals("")) {
            var.put("message", message);
            response.setStatus(HttpServletResponse.SC_OK);
        } else
            response.setStatus(403);
        response.getWriter().println(PageGenerator.inst().getPage("index.html", var));
        response.setContentType("text/html;charset=utf-8");
    }
}
