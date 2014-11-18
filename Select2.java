import java.sql.*;

public class Select2 {
	private String _user = "s13006";
	private String _pass = "password";
	private String _host = "172.16.40.4";
	private String _sid = "db11";
	
	public static void main(String[] args){

		Select2 sample = new Select2();
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

            String sql = "select e.empno, e.ename, e.job, e.ename, d.dname, d.loc from DEPARTMENTS d, EMPLOYEES E";
            PreparedStatement pre = conn.prepareStatement(sql);
            ResultSet resultSet = pre.executeQuery();


			while(resultSet.next()){
				String empno = resultSet.getString(1);
				String ename1 = resultSet.getString(2);
                String job = resultSet.getString(3);
                String ename2 = resultSet.getString(4);
                String dname = resultSet.getString(5);
                String loc = resultSet.getString(6);

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
