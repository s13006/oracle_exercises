INSERT INTO employees(empno, ename, hiredate)
VALUES (&empno, '&&ename', TO_DATE('&年-&月-&日','YYYY-MM-DD'));
commit;

SELECT empno, ename, hiredate FROM employees;

DELETE FROM employees
WHERE ename = '&ename';
commit;

SELECT empno, ename, hiredate FROM employees;
