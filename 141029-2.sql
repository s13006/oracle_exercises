SELECT empno, ename, deptno
FROM employees
WHERE ( SELECT dname FROM departments WHERE dname = '営業') = '営業'
/
