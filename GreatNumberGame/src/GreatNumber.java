

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class GreatNumber
 */
@WebServlet("/GreatNumber")
public class GreatNumber extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GreatNumber() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher view = request.getRequestDispatcher("/WEB-INF/game.jsp");
		view.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		HttpSession session = request.getSession();
		Integer answer = (Integer) session.getAttribute("answer");
		Integer attempt = Integer.parseInt(request.getParameter("attempt"));
		Random randomizer = new Random();
		if(session.getAttribute("answer") == null) {
			session.setAttribute("answer", randomizer.nextInt(100));
		}
		else if(attempt.equals(answer)) {
			session.setAttribute("answer", randomizer.nextInt(100));
			session.setAttribute("response", "correct");
		}
		else if(attempt > answer) {
			session.setAttribute("response", "Too high");
		}
		else if(attempt < answer) {
			session.setAttribute("response", "Too low");
		}
		doGet(request, response);
	}

}
