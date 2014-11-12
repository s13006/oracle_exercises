create table emp2(empno primary key, ename not null, sal, deptno)
as select empno, ename, sal, deptno from employees
/

CREATE VIEW v_emp
AS SELECT empno, ename, sal, deptno
   FROM emp2
/

SELECT * FROM v_emp
/

DELETE FROM v_emp
WHERE empno = 1014
/

UPDATE v_emp
SET sal = 300000
WHERE empno = 1013
/

INSERT INTO v_emp(empno, ename, sal, deptno)
VALUES (1030, '山口', 200000, null)
/

SELECT * FROM v_emp
/

DROP TABLE emp2
/

DROP VIEW v_emp
/
