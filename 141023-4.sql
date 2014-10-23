SELECT e.sal, s.losal, s.hisal
FROM employees e
JOIN salgrades s ON e.sal BETWEEN s.losal AND s.hisal
/
