SELECT empno, ename, sal, deptno
FROM employees
WHERE 1003 <= ANY (SELECT empno FROM employees WHERE empno >= 1003)
AND (SELECT dname FROM departments WHERE dname = '営業') = '営業'
/
