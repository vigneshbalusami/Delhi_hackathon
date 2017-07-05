

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RetriveChemicals
 */
@WebServlet("/retriveChemicals")
public class RetriveChemicals extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RetriveChemicals() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out = response.getWriter()){
			
			
			try{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select mn from chemicals ");
			int count=0;
			out.print("<table><tr>");
			while(rs.next()){
				out.print("<td>"+rs.getString(1)+"</td>");
				count++;
				if(count%3==0){
					out.print("</tr><tr>");
				}
			}
			out.print("</tr>");
			}
		catch (Exception e){
			out.println(e);
		}
		}
		catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
