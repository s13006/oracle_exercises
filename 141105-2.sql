UPDATE emp_copy
    SET ename = '吉田',
        deptno = 30
    WHERE empno = 1012
/

SELECT * FROM emp_copy
/

ROLLBACK/

SELECT * FROM emp_copy
/
