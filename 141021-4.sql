SELECT ename,
       CASE deptno WHEN 10 THEN 1.1 * sal
                   WHEN 20 THEN 1.2 * sal
       ELSE        sal END NEW_SAL
FROM employees
/
