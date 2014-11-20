import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

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

            PreparedStatement pre = conn.prepareStatement("select e.empno, e.ename, e.job, m.ename, d.dname, d.loc, e.sal from EMPLOYEES E " +
                    "left join EMPLOYEES M on (e.mgr = m.empno)" +
                    "left join DEPARTMENTS D on (e.deptno = d.deptno)" +
                    "order by e.empno");
            rs = pre.executeQuery();

            while (rs.next()){
                String empno = rs.getString(1);
                String ename1 = rs.getString(2);
                String job = rs.getString(3);
                String ename2 = rs.getString(4);
                String dname = rs.getString(5);
                String loc = rs.getString(6);
                String sal = rs.getString(7);

                System.out.println(empno + "   " + ename1 + "  " + job + "  " + ename2 + "  " + dname + "  " + loc + "  " + sal);
            }

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

            System.out.println("empno を入力してください。");
            String str = br.readLine();
            int prefCd = Integer.parseInt(str);

            pre = conn.prepareStatement("SELECT emp.empno, emp.ename, emp.job, mgr.ename, dept.dname, dept.loc," +
                    "emp.sal, grd.grade " +
                    "FROM employees emp LEFT JOIN employees mgr " +
                    "ON (emp.mgr = mgr.empno) " +
                    "LEFT JOIN departments dept " +
                    "ON (emp.deptno = dept.deptno) " +
                    "LEFT JOIN salgrades grd " +
                    "ON emp.sal BETWEEN grd.losal AND grd.hisal " +
                    "WHERE emp.empno = '" + prefCd + "' " +
                    "ORDER BY emp.empno");

            rs = pre.executeQuery();

			while(rs.next()){
				String empno = rs.getString(1);
				String ename1 = rs.getString(2);
                String job = rs.getString(3);
                String ename2 = rs.getString(4);
                String dname = rs.getString(5);
                String loc = rs.getString(6);
                String sal = rs.getString(7);
                String comm = rs.getString(8);

                System.out.println("▼　従業員　▼");
				System.out.println(empno + "   " + ename1 + "  " + job + "  " + ename2 + "  " + dname + "  " + loc + "  " + sal + "  " + comm);
			}

            pre = conn.prepareStatement("SELECT emp.empno, emp.ename, emp.job, dept.dname, dept.loc," +
                    "emp.sal, grd.grade " +
                    "FROM employees emp LEFT JOIN employees mgr " +
                    "ON (emp.mgr = mgr.empno) " +
                    "LEFT JOIN departments dept " +
                    "ON (emp.deptno = dept.deptno) " +
                    "LEFT JOIN salgrades grd " +
                    "ON emp.sal BETWEEN grd.losal AND grd.hisal " +
                    "WHERE mgr.empno = '" + prefCd + "' " +
                    "ORDER BY emp.empno");

            rs = pre.executeQuery();

            if (!rs.next()) {
                System.out.println("▼　部下はいません　▼");
            }

            while(rs.next()){
                String empno = rs.getString(1);
                String ename1 = rs.getString(2);
                String job = rs.getString(3);
                String dname = rs.getString(4);
                String loc = rs.getString(5);
                String sal = rs.getString(6);
                String grd = rs.getString(7);

                System.out.println("▼　部下　▼");
                System.out.println(empno + "   " + ename1 + "  " + job + "  " + dname + "  " + loc + "  " + sal + "  " + grd);
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
