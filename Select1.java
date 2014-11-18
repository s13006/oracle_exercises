import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Select1 {
	private String _user = "s13006";
	private String _pass = "password";
	private String _host = "172.16.40.4";
	private String _sid = "db11";
	
	public static void main(String[] args){

		Select1 sample = new Select1();
		try {
			sample.select();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

	private void select() throws Exception{
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection(
					"jdbc:oracle:thin:@" + _host + ":1521:" + _sid, _user, _pass);

			st = conn.createStatement();

			rs = st.executeQuery("select e.empno, e.ename, e.job, e.ename, d.dname, d.loc from DEPARTMENTS d, EMPLOYEES E");

			while(rs.next()){
				String empno = rs.getString(1);
				String ename1 = rs.getString(2);
                String job = rs.getString(3);
                String ename2 = rs.getString(4);
                String dname = rs.getString(5);
                String loc = rs.getString(6);

//                System.out.println("社員番号  社員名  職種  上司の名前  部署名  場所");
				System.out.println(empno + "   " + ename1 + "  " + job + "  " + ename2 + "  " + dname + "  " + loc);
			}
		}catch(ClassNotFoundException e){
			throw e;
		}catch(SQLException e){
			throw e;
		}catch(Exception e){
			throw e;
		}finally{
			if(conn != null){
				conn.close();
			}
			if(st != null){
				st.close();
				st = null;
			}
			if(rs != null){
				rs.close();
				rs = null;
			}
		}
	}
}
