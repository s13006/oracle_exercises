SELECT e.empno, e.ename, m.ename
FROM employees e JOIN employees m
ON (e.mgr = m.empno)
WHERE e.empno = ANY (SELECT mgr FROM employees
                WHERE ename IN('伊藤', '山田'))
/
