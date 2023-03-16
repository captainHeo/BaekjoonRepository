-- 코드를 입력하세요
SELECT CAR_ID, 
    CASE 
        WHEN CAR_ID IN 
        (
            -- 대여 날짜나 반납 날짜가 2022년 10월 16일인 CAR_ID
            SELECT CAR_ID
            FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
            WHERE '2022-10-16' BETWEEN START_DATE AND END_DATE
        ) THEN '대여중'
        ELSE '대여 가능'
    END AS AVAILABILITY
FROM CAR_RENTAL_COMPANY_RENTAL_HISTORY
GROUP BY CAR_ID
-- 자동차 ID를 기준으로 내림차순 정렬
ORDER BY CAR_ID DESC;