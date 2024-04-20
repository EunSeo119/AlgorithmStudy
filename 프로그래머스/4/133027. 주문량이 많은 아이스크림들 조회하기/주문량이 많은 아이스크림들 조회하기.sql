-- 코드를 입력하세요
SELECT FLAVOR
FROM (SELECT * FROM FIRST_HALF UNION SELECT * FROM JULY) AS S
GROUP BY FLAVOR
ORDER BY SUM(TOTAL_ORDER) DESC
LIMIT 3;