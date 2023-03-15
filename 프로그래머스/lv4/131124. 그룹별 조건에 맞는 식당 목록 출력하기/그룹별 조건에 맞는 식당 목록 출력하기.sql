-- 코드를 입력하세요
SELECT M.MEMBER_NAME, R.REVIEW_TEXT, DATE_FORMAT(R.REVIEW_DATE, "%Y-%m-%d") AS REVIEW_DATE
FROM MEMBER_PROFILE M INNER JOIN REST_REVIEW R
ON M.MEMBER_ID = R.MEMBER_ID
WHERE M.MEMBER_ID = 
-- 리뷰 테이블에서 회원 아이디를 그룹핑하고 그룹핑한 값 카운트해서 내림차순하고 제일 첫번째꺼
(SELECT MEMBER_ID 
FROM REST_REVIEW
GROUP BY MEMBER_ID
ORDER BY COUNT(*) DESC LIMIT 1)

ORDER BY REVIEW_DATE, REVIEW_TEXT;