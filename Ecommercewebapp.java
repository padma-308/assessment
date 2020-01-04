import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Ecommercewebapp
 */
@WebServlet("/Ecommercewebapp")
public class Ecommercewebapp extends HttpServlet {
	private static final long serialVersionUID = 1L;
	productDAO dao;
	product p;
	printWriter out;
	

    /**
     * Default constructor. 
     */
    public Ecommercewebapp() {
    	dao=new productDAO();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		try
		{
			out=response.getWriter();
			int id=Integer.parseInt(request.getParameter("id"));
			ResultSet res=dao.retrieve(id);
			resultSet res1=dao.retrieve(loginId);
			out.println("<table border=3><tr><th>id</th><th>name</th><th>price</th><th>category</th></tr>");
			while(res.next())
			{
				out.println("<tr>");
				out.println("<td>"+res.getInt("id")+<"/td>");
				out.println("<td>"+res.getString("name")+"</td>");
				out.println("<td>"+res.getString("price")+"</td>");
				out.println("<td>"+res.getString("category")+"</td>");
			}
			out.println("</table>");
			out.println("<table border=3><tr><th>loginId</th><th>email</th><th>mobno</th></tr>");
			while(res1.next())
			{
			    out.println("<tr>");
			    out.println("<td>"+res1.getString("loginId")+"</td>");
			    out.println("<td>"+res1.getString("email")+"</td>");
			    out.println("<td>"+res1.getString("mobno")+"</td>");
			}
			out.println("</table>");
			
			out.println("<html><body>to log out<a onclick="alert("your session is expired")>logout</a> ");
			
			    
			
			
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
		PrintWriter out=response.getWriter();
		pre=con.prepareStatement("insert into product values(?,?,?,?,?)");
		
		int sid=Integer.parseInt(request.getParameter("id"));
		String name=request.getParameter("name");
		String price=request.getParameter("price");
		String category=request.getParameter("category");
		
		
		pre.setInt(1, id);
		pre.setString(2,name);
		pre.setString(3,price);
		pre.setString(4,category);
	
		
		int ra=pre.executeUpdate();
		if(ra>0)
			out.println("<font color=yellow>Student Details Inserted Succcessfully.</font>");
		else
			out.println("<font color=blue>Student Details are not inserted.</font>");
		out.println("To Go Back To The Form <a href='http://localhost:9090/StudentSystem/input2.html'>Click Here</a>");	
	}
	catch(Exception e)
	{
		e.printStackTrace();
	}
}

}

	}

}
