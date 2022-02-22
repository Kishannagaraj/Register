import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;


public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public Register() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		String uname= request.getParameter("uname");
		String password= request.getParameter("password");
		String email= request.getParameter("email");
		String phone= request.getParameter("phone");
		
		Member member = new Member(uname, password, email, phone);
		
		RegisterDAO rDAO= new RegisterDAO();
		
			String result=null;
			try {
				result = rDAO.insert(member);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			response.getWriter().print(result);	
	}

	
}
