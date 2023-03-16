-- 코드를 입력하세요
SELECT B.user_id , nickname, sum(price) total_sales
FROM USED_GOODS_BOARD A INNER JOIN USED_GOODS_USER B 
ON A.writer_id = B.user_id
--  완료된 중고 거래
WHERE STATUS = 'DONE'
-- 중고거래를 완료한 회원의 총거래금액을 조회해야 하므로 그룹핑
GROUP BY B.user_id
-- 완료된 중고 거래의 총금액이 70만 원 이상
HAVING total_sales >= 700000
-- 총거래금액을 기준으로 오름차순 정렬
ORDER BY total_sales;
