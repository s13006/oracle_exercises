SELECT worker.empno, worker.ename, manager.empno, manager.ename
FROM employees worker JOIN employees manager
ON worker.mgr = manager.empno
/
