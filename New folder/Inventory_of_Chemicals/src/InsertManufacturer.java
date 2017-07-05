

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
 * Servlet implementation class insert
 */
@WebServlet("/insert")
public class InsertManufacturer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertManufacturer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try(PrintWriter out = response.getWriter()) {
			
				String name = request.getParameter("name");
				String ibn=request.getParameter("IBN");
				String email = request.getParameter("email");
				String companyname = request.getParameter("companyname");
				String mobile = request.getParameter("mobile");
				String role = request.getParameter("role");
				String job = request.getParameter("job");
				String cpprd = request.getParameter("cpprd");
				String password = request.getParameter("password");
				 //ps = Database.getStmt("select * from signupform ");
			
				try{
					response.setContentType("text/html");
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb","root","");
					Statement st=con.createStatement();
					
					ResultSet rs=st.executeQuery("select * from signupform where ibn='"+ibn+"'");
					if(rs.next()){
						out.print("Manuacturer already exists!!");
					}else{
					st.executeUpdate("insert into signupform values('"+name+"','"+ibn+"','"+email+"','"+companyname+"','"+mobile+"','"+role+"','"+job+"','"+cpprd+"','"+password+"')");
					out.println("Inserted Successfully</br>");
					//out.println("<a href=insert.html>click here</a> for another response</br>");
					//out.println("<a href=index.html>Home</a>");
					}
					}
				catch (Exception e){
					out.println(e);
				}
				
				
			} catch (Exception e) {

			System.out.println(e);
			}
		}
	}


