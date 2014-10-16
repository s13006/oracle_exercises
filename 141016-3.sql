alter session set nls_date_format = 'DD-MON-RR';
alter session set nls_date_language = 'AMERICAN';
SELECT ename, TO_CHAR(hiredate, 'YYTH" of "Month', 'NLS_DATE_LANGUAGE = ENGLISH')
FROM employees
/
