SELECT MAX(AVG(sal))
FROM employees
GROUP BY deptno, sal
ORDER BY deptno
/
