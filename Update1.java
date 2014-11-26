import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.*;
import java.util.Scanner;

public class Update1 {
	private String _user = "s13006";
	private String _pass = "password";
	private String _host = "172.16.40.4";
	private String _sid = "db11";
	
	public static void main(String[] args){

		Update1 sample = new Update1();
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

//            String empno, ename, yomi, job, mgr, hiredate, sal, comm, deptno;
            System.out.println("empno を入力してください。");
            String empno = br.readLine();
            pre = conn.prepareStatement("SELECT * FROM employees WHERE empno = ?");
            pre.setInt(1, Integer.parseInt(empno));
            rs = pre.executeQuery();
            rs.next();
            String ename = rs.getString(2);
            String yomi = rs.getString(3);
            String job = rs.getString(4);
            int mgr = rs.getInt(5);
            String hiredate = rs.getString(6).substring(0,9);
            int sal = rs.getInt(7);
            int comm = rs.getInt(8);
            int deptno = rs.getInt(9);


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
                mgr = Integer.parseInt(hoge);
            }

            System.out.println("hiredateを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                hiredate = hoge;
            }
            System.out.println("salを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                sal = Integer.parseInt(hoge);
            }

            System.out.println("commを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                comm = Integer.parseInt(hoge);
            }
            System.out.println("deptnoを入力してください。");
            hoge = br.readLine();
            if (!hoge.equals("")) {
                deptno = Integer.parseInt(hoge);
            }
//            1009   小林  主任  渡辺  研究開発  横浜  300000

            pre = conn.prepareStatement("UPDATE employees SET ename = ?, yomi = ?, job = ?, " +
                                                             "mgr = ?, hiredate = ?, sal = ?, comm = ?, deptno = ? " +
                                                             "WHERE  empno = ? ");
            pre.setInt(9, Integer.parseInt(empno));
            pre.setString(1, ename);
            pre.setString(2, yomi);
            pre.setString(3, job);
            pre.setInt(4, mgr);
            pre.setString(5, hiredate);
            pre.setInt(6, sal);
            pre.setInt(7, comm);
            pre.setInt(8, deptno);
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
