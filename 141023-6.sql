SELECT worker.empno, worker.ename, manager.empno, manager.ename
FROM employees worker LEFT OUTER JOIN employees manager
ON worker.mgr = manager.empno
/
