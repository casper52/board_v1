package org.kidding.web;

import org.kidding.dao.BoardDAO;
import org.kidding.domain.BoardVO;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/modify")
public class ModifyController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        BoardDAO boardDAO=new BoardDAO();

        BoardVO vo = boardDAO.readContent(Integer.parseInt(req.getParameter("bno")));
        req.setAttribute("board",vo);

        req.setAttribute("page",req.getParameter("page"));

        RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/modify.jsp");
        dispatcher.forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        BoardDAO boardDAO=new BoardDAO();

        BoardVO vo = new BoardVO();
        int bno = Integer.parseInt(req.getParameter("bno"));

        String title = req.getParameter("title");
        String content = req.getParameter("content");
        String page = req.getParameter("page");

        vo.setBno(bno);                 // 여기서 vo에 담아주고 vo 형태로 ModifyDAO를 통해 넣어줌.
        vo.setTitle(title);
        vo.setContent(content);


        boardDAO.modifyContent(vo);

        resp.sendRedirect("/read?bno=" + bno + "&page=" + page);
    }
}