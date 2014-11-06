INSERT INTO dept_copy (deptno, dname, loc)
    VALUES (70, '海外', '浦添')
/

SAVEPOINT save
/

INSERT INTO dept_copy (deptno, dname, loc)
    VALUES (80, '製造', 'うるま')
/

SELECT * FROM dept_copy
/

ROLLBACK TO save
/

SELECT * FROM dept_copy
/
