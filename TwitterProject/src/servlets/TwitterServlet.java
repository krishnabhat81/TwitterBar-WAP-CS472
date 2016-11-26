package servlets;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import classes.Tweet;
import models.ModelTwitter;

/**
 * Servlet implementation class TwitterServlet
 */
@WebServlet("/twitterServlet.ajax")
public class TwitterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private String queryString;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public TwitterServlet() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (request.getParameter("query") == ""){
			queryString = "documentry";//default query
		} else {
			queryString = request.getParameter("query");
		}
				
		ModelTwitter twitterModel = new ModelTwitter();
		List<Tweet> list = twitterModel.fetchTweets(queryString);
		
		response.setCharacterEncoding("utf-8");
		response.setContentType("application/json");
		response.getWriter().write(new Gson().toJson(list));//tweets to json
		
		//request.getRequestDispatcher("index.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
