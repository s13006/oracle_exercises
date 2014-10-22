SELECT deptno, job, COUNT(deptno), AVG(sal)
FROM employees
HAVING COUNT(deptno) >= 2
GROUP BY deptno, job
/
