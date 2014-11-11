CREATE TABLE dept1(
    deptno number(4),
    dname varchar(10) not null,
    loc varchar(10),
    CONSTRAINT dept1_deptno_pk
        PRIMARY KEY (deptno))
/
INSERT INTO dept1(deptno, dname)
VALUES (10, '佐藤')
/
INSERT INTO dept1(deptno, dname)
VALUES (10, '山田')
/
INSERT INTO dept1(deptno,)
VALUES (10)
/

DROP TABLE dept1
/
