SELECT o.ordno, o.date_ordered, c.cname, e.ename
FROM employees e
JOIN orders o ON e.empno = o.salesman_no
JOIN customers c ON o.custno = c.custno
/
