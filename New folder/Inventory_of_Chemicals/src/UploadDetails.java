

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
 * Servlet implementation class UploadDetails
 */
@WebServlet("/uploadDetails")
public class UploadDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		try(PrintWriter out = response.getWriter()){
			
			String mn=request.getParameter("MARKETING NAME(S)");
			String cas=request.getParameter("CAS NUMBER");
			String cn=request.getParameter("CHEMICAL NAME");
			String othern=request.getParameter("OTHER NAME(S)");
			String mf=request.getParameter("MOLECULAR FORMULA");
			String sf=request.getParameter("STRUCTURAL FORMULA");
			String namw=request.getParameter("Number Average Molecular Weight(Mn)");
			String wamw=request.getParameter("Weight Average Molecular Weight(Mw)");
			String lmlt=request.getParameter("% of Low MW Species < 1000 DA");
			String lmlf=request.getParameter("% of Low MW Species < 500 DA");
			String dop=request.getParameter("DEGREE OF PURITY");
			String himp=request.getParameter("HAZARDOUS IMPURITIES/RESIDUAL MONOMERS(if none write 'NONE')");
			String nhimp=request.getParameter("NON HAZARDOUS IMPURITIES/RESIDUAL MONOMERS(if none write 'NONE')");
			String tonnes1=request.getParameter("Tonnes1");
			String tonnes2=request.getParameter("Tonnes2");
			String tonnes3=request.getParameter("Tonnes3");
			String tonnes4=request.getParameter("Tonnes4");
			String tonnes5=request.getParameter("Tonnes5");
			try{
			response.setContentType("text/html");
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/appdb","root","");
			Statement st=con.createStatement();
			ResultSet rs=st.executeQuery("select * from chemicals where cas='"+cas+"'");
			if(rs.next()){
				out.print("chemical already exists!!");
			}else{
			st.executeUpdate("insert into chemicals values('"+mn+"','"+cas+"','"+cn+"','"+othern+"','"+mf+"','"+sf+"','"+namw+"','"+wamw+"','"+lmlt+"','"+lmlf+"','"+dop+"','"+himp+"','"+nhimp+"','"+tonnes1+"','"+tonnes2+"','"+tonnes3+"','"+tonnes4+"','"+tonnes5+"')");
			out.println("Inserted Successfully</br>");
			out.println("<a href=insert.html>click here</a> for another response</br>");
			out.println("<a href=index.html>Home</a>");
			}
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
