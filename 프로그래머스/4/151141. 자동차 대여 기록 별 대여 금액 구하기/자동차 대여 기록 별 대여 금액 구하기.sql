-- 3개의 테이블 조인하기 
-- (해당 경우 SELECT 절에 어떤 테이블 꺼인지 앞에 명시 안해도 ㄱㅊ - why? 조인해서 테이블에 두개가 되는 컬럼이 아니기 때문(FK도 조인하면 같은 컬럼이 두개가 생김 그럴땐 어떤 테이블꺼인지 명시해줘야함))
-- 다시 해보기!!!!!!!! + OPTIONS를 활용한 응용 문제도
SELECT HISTORY_ID, ROUND(DAILY_FEE * (DATEDIFF(END_DATE, START_DATE)+1)
                        * (CASE
                            WHEN DATEDIFF(END_DATE, START_DATE)+1 < 7 THEN 1
                            WHEN DATEDIFF(END_DATE, START_DATE)+1 < 30 THEN 0.95
                            WHEN DATEDIFF(END_DATE, START_DATE)+1 < 90 THEN 0.92
                            ELSE 0.85
                           END)
                        ) AS FEE
FROM CAR_RENTAL_COMPANY_CAR C
JOIN CAR_RENTAL_COMPANY_RENTAL_HISTORY H
ON C.CAR_ID = H.CAR_ID
JOIN CAR_RENTAL_COMPANY_DISCOUNT_PLAN P
ON C.CAR_TYPE = P.CAR_TYPE
WHERE C.CAR_TYPE = '트럭'
GROUP BY HISTORY_ID
ORDER BY 2 DESC, 1 DESC;

-- 아래 코드로 트럭의 할인율 확인 뒤 THEN 뒤에 해당 값을 임의로 넣음
# SELECT *
# FROM CAR_RENTAL_COMPANY_DISCOUNT_PLAN;