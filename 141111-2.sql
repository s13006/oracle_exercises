CREATE TABLE emp1(
    empno number(4) CONSTRAINT emp1_empno_pk PRIMARY KEY,
    ename varchar2(10) CONSTRAINT emp1_ename_nn NOT NULL,
    deptno number(4),
    CONSTRAINT emp1_dept1_deptno_fk FOREIGN KEY (deptno)
        REFERENCES departments(deptno))
/

INSERT INTO emp1(empno, ename)
VALUES (10, '佐藤')
/
INSERT INTO emp1(empno, ename)
VALUES (10, '田中')
/
INSERT INTO emp1(empno)
VALUES (10)
/
INSERT INTO emp1(empno, ename, deptno)
VALUES (20, '佐藤', 100)
/

DROP TABLE emp1
/
