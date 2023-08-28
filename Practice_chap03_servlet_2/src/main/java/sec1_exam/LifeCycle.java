package sec1_exam;

import java.io.IOException;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LC")
public class LifeCycle extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	public void init() throws ServletException {
		System.out.println("Init() 호출");
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet()호출");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost()호출");
	}
	
	@Override
	public void destroy() {
		System.out.println("Destroy() 호출");
	}
	
	@PostConstruct
	private void initPostConstructor() {
		System.out.println("생성자 호출 후 init 직전 호출");
	}
	
	@PreDestroy
	private void destroyPredestroy() {
		System.out.println("destroy 호출 직전");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) throws ServletException, IOException {
		System.out.println("service 호출은 요청마다");
	}
	
	/*constructor -> postconstruct -> init -> doget or dopost ->
	 * predestroy -> destroy*/

}
