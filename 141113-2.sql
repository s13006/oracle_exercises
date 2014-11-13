CREATE SYNONYM dept_s
FOR employees
/

SELECT * FROM dept_s
/

DROP SYNONYM dept_s
/
