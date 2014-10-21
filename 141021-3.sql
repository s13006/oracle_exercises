SELECT ename, sal, COALESCE(comm, 0), sal + COALESCE(comm,  0)
FROM employees
/
