SELECT ename, sal, NVL(comm, 0), sal + NVL(comm, 0)
FROM employees
/
