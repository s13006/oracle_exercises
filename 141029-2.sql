SELECT empno, ename, deptno
FROM employees
WHERE deptno = ( SELECT deptno FROM departments WHERE dname = '営業')
/
