import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;

public class Insart1 {
	private String _user = "s13006";
	private String _pass = "password";
	private String _host = "172.16.40.4";
	private String _sid = "db11";
	
	public static void main(String[] args){

		Insart1 sample = new Insart1();
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

            int maxEmpno = 0;
            while (rs.next()){
                if (maxEmpno < rs.getInt(1)) {
                    maxEmpno = rs.getInt(1);
                }
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

            String ename = null;
            String yomi = null;
            String job = null;
            String mgr = null;
            String hiredate = null;
            String sal = null;
            String comm = null;
            String deptno = null;
            int empno = maxEmpno + 1;

            System.out.println("ename を入力してください。");
            String hoge = br.readLine();
            if (!hoge.equals("")) {
                ename = hoge;
            }

            System.out.println("yomiを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                yomi = hoge;
            }

            System.out.println("jobを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                job = hoge;
            }
            System.out.println("mgrを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                mgr = hoge;
            }

            System.out.println("hiredateを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                hiredate = hoge;
            }
            System.out.println("salを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                sal = hoge;
            }

            System.out.println("commを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                comm = hoge;
            }
            System.out.println("deptnoを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                deptno = hoge;
            }

            pre = conn.prepareStatement("INSERT INTO employees VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pre.setInt(1, empno);
            pre.setString(2, ename);
            pre.setString(3, yomi);
            pre.setString(4, job);
            pre.setString(5, mgr);
            pre.setString(6, hiredate);
            pre.setString(7, sal);
            pre.setString(8, comm);
            pre.setString(9, deptno);
            pre.executeUpdate();
            System.out.println("更新しました。");

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
