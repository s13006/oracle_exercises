SELECT deptno, dname, AVG(sal)
FROM departments JOIN employees
USING (deptno)
GROUP BY deptno, dname
HAVING AVG(sal) >= (SELECT AVG(sal) FROM employees)
/
