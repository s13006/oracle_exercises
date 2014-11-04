INSERT INTO departments(deptno, dname, loc)
VALUES (60, '経理', null);
commit;

SELECT deptno, dname, loc FROM departments;

DELETE FROM departments
WHERE dname = '経理';
commit;

SELECT deptno, dname, loc FROM departments;
