package com.controller;

import com.pojo.UserOne;
import com.service.UserOneService;
import org.springframework.context.ApplicationContext;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;
@WebServlet("/index")
public class HomeController extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(req.getServletContext());

        UserOneService service = context.getBean(UserOneService.class);
        int pageNum = ServletRequestUtils.getIntParameter(req, "pageNum",1);
        int pageSize = ServletRequestUtils.getIntParameter(req, "pageSize",3);
        List<UserOne> result = service.getPageAll(pageNum, pageSize);
        req.setAttribute("list", result);
        req.getRequestDispatcher("index.jsp").forward(req, resp);

    }
}
