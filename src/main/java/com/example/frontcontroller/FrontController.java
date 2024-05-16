package com.example.frontcontroller;

import com.example.controller.Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("*.do")
public class FrontController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String reqPath = req.getRequestURI();   // /MF01/list.do 같은
        String cpath = req.getContextPath();    // /MF01
        String command = reqPath.substring(cpath.length()); // /list.do


        // HandlerMapping(요청--> POJO)
        HandlerMapping mapping = new HandlerMapping();
        Controller controller = mapping.getController(command);

        if(controller == null){
            // 에러페이지로 로딩
            return;
        }

        String nextView = controller.requestHandler(req, resp);

        navigate(req, resp, nextView);

    }



        private void navigate(HttpServletRequest req, HttpServletResponse resp, String nextView) throws ServletException, IOException {
        if(nextView != null){
            if(!nextView.contains(":/")){
                // forward
                RequestDispatcher rd = req.getRequestDispatcher(ViewResolver.makeView(nextView));
                rd.forward(req, resp);
            } else {
                // redirect
                //http://localhost:8081/MF01/list.do
                System.out.println("nextView = " + nextView);
                resp.sendRedirect(nextView.split(":/")[1]);  // redirect://list.do -> list.do
            }
        };
    }
}
