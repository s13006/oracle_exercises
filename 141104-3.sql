INSERT INTO employees(empno, ename, hiredate)
VALUES (&empno, &ename, &hiredate);
commit;

SELECT empno, ename, hiredate FROM employees;

DELETE FROM employees;
WHERE ename = &ename;
commit;

SELECT empno, ename, hiredate FROM employees;
