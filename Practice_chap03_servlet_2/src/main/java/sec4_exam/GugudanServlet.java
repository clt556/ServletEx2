package sec4_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/gugudan")
public class GugudanServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		
		PrintWriter writer = response.getWriter();
		
		int number = Integer.parseInt(request.getParameter("number"));
		//getParameter는 무조건 String으로 리턴함
		
		//예외처리 
		if(number < 1 || number > 9) {
			writer.print("1에서 9까지만 입력 가능합니다");
			writer.print("<a href='http://localhost:8090/Practice_chap03_servlet_2/gugudan.html'>폼으로 이동하기</a>");
			return;
		}
		
		
		writer.print("<table border=1 width=800 align=center>");
		writer.print("<tr align=center bgcolor='#ffff66'>");
		writer.print("<td colspan=4>" + number + "단 출력</td>");
		
		for(int i = 1; i< 10; i++) {
			if(i % 2 == 0) {
				writer.print("<tr align=center bgcolor='#ACFA58'>");
			}else {
				writer.print("<tr align=center bgcolor='#81bef7'>");
			}
			
			writer.print("<td width=200>" + number + "</td>");
			writer.print("<td width=200>" + i + "</td>");
			writer.print("<td width=200>" + number+"x"+i + "</td>");
			writer.print("<td width=200>" + number*i + "</td>");
			writer.print("</tr>");
		}
		
		writer.print("</table>");
		writer.close();
	}

}
