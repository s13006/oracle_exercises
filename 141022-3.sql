SELECT deptno, job, COUNT(deptno), AVG(sal)
FROM employees
GROUP BY deptno, job
ORDER BY deptno
/
