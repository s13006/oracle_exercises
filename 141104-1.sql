INSERT INTO departments(deptno, dname, loc)
VALUES (50, '教育', '大手町');
commit;

SELECT deptno, dname, loc FROM departments;

DELETE FROM departments
WHERE dname = '教育';
commit;

SELECT deptno, dname, loc FROM departments;
