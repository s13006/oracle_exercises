SELECT e.empno, e.ename, d.dname
FROM employees e
JOIN departments d
ON e.deptno = d.deptno
WHERE d.deptno IN(10,20)
/
