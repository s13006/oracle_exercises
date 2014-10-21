SELECT ename, sal, NVL2(comm, comm, 0), sal + NVL2(comm, comm, 0)
FROM employees
/
