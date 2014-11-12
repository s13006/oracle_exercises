CREATE VIEW v_emp_dept
AS SELECT e.empno, e.ename, d.dname
   FROM employees e JOIN departments d
   ON e.deptno = d.deptno
   WHERE d.deptno = 10
/

SELECT * FROM v_emp_dept
/

DROP VIEW v_emp_dept
/
