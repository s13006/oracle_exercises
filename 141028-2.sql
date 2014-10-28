SELECT empno, ename, deptno, dname
FROM employees LEFT OUTER JOIN departments
USING (deptno)
/
