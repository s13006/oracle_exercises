SELECT ename,
       DECODE(deptno, 10, 1.1 * sal,
                      20, 1.2 * sal,
              sal)
       NEW_SAL
FROM employees
/
