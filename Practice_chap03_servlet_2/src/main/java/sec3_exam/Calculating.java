package sec3_exam;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/Calculating")
public class Calculating extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private static float USD_RATE = 1327.00F;
	private static float JPY_RATE = 906.14F;
	private static float CNY_RATE = 181.89F;
	private static float EUR_RATE = 1432.16F;
	
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=utf-8");
		PrintWriter writer = response.getWriter();
		
		String command = request.getParameter("command");
		String won = request.getParameter("won");
		String operator = request.getParameter("operator");
		
		if(command != null && command.equals("calculate")) {
			String result = calculate(Float.parseFloat(won),operator);
			writer.print("<html><font size=10>변환 결과</font>");
			writer.print("<font size=10>" + result + "</font><br/>");
			writer.print("<a href='Calculating'>환율 계산기</a>");
			return;
		}
		//doGet 함수 자체를 return 하게 해버리면, 환율 폼 렌더링을 안하게 할 수 있음
		/*
		 * 일반적으로는 이렇게 doGet에 초기 폼을 넣어주지 않고, 
		 * 정적인 html로 만들어서 배포하고
		 * 그 배포판에서 온 데이터를 서버사이드에서 처리할 때 서블릿을 사용할 것.*/
		
		writer.print("<html><title>환율 계산기</title>");
		writer.print("<font size=5>환율 계산기</font><br/>");
		writer.print("<form name='frmCalc' method='get' action='Calculating'>");
		writer.print("원화: <input type='text' name='won' size=10/>");
		writer.print("<select name='operator' >");
		writer.print("<option value='dollar' >달러</option>");
		writer.print("<option value='en' >엔</option>");
		writer.print("<option value='wian' >위안</option>");
		writer.print("<option value='euro' >유로</option>");
		writer.print("</select>");
		writer.print("<input type='hidden' name='command' value='calculate'>");
		writer.print("<input type='submit' value='변환하기' />");
		writer.print("</form>");
		writer.print("</html>");
		
		writer.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	private static String calculate(float won, String operator) {
		String result = null;
		
		if(operator.equals("dollar")) {
			result = String.format("%.6f", won / USD_RATE);
		}else if(operator.equals("en")) {
			result = String.format("%.6f", won / JPY_RATE);
		} else if(operator.equals("wian")) {
			result = String.format("%.6f", won / CNY_RATE);
		} else {
			result = String.format("%.6f", won / EUR_RATE);
		}
		
		return result;
	}
}
