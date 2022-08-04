

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ProductManagement
 */
@WebServlet("/ProductManagement")
public class ProductManagement extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductManagement() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {
			PrintWriter out=response.getWriter();
			Connection con=DBConnection.getMyConnection();
			String pid=request.getParameter("pid");
			
			String str="select * from productdetails where pid="+pid;
			
			Statement ps=con.createStatement();
			
			ResultSet ans=ps.executeQuery(str);
			
			if(ans.next()) {
				out.println("<table border=3>");
				out.println("<tr><th>PID</th><th>Name</th><th>Category</th><th>Price</th></tr>");
				out.println("<tr>");
				out.print("<td>"+ans.getInt("pid")+"</td>");
				out.print("<td>"+ans.getString("name")+"</td>");
				out.print("<td>"+ans.getString("category")+"</td>");
				out.print("<td>"+ans.getInt("price")+"</td>");
				out.println("</tr>");
				out.println("</table>");
			}
			else {
			out.println("No records found!");
			}
			con.close();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
		
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
