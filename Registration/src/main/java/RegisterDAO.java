import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class RegisterDAO {
	
	private String dburl ="jdbc:mysql://localhost:3306/userdb";
	private String dbname ="root";
	private String dbPassword ="Kishan@123";
	private String dbDriver ="com.mysql.cj.jdbc.Driver";
	Connection con = null;

	public void loadDriver(String dbDriver) 
	{
		try {
			Class.forName(dbDriver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConnection() throws SQLException 
	{
		
		
		if(con==null)
		{
		
				con = DriverManager.getConnection(dburl,dbname,dbPassword);
			
		}
		return con;
		
		
		
	}
	public String insert(Member member) throws SQLException 
	{
		loadDriver(dbDriver);
		Connection con = getConnection();
		String result ="Data entered successfully";
		
		String query = "insert into member values(?,?,?,?)";
		
		PreparedStatement ps;
		try 
		{
		ps = con.prepareStatement(query);
		ps.setString(1, member.getUname());
		ps.setString(2, member.getPassword());
		ps.setString(3, member.getEmail());
		ps.setString(4, member.getPhone());
	
		ps.executeUpdate();
		}
		catch(SQLException e){
			e.printStackTrace();
			result = "Data not added";
		}
		return result;
		
	}
	
}
