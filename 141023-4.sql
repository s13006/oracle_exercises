SELECT e.sal, s.losal, s.hisal, s.grade
FROM employees e
JOIN salgrades s ON e.sal BETWEEN s.losal AND s.hisal
/
