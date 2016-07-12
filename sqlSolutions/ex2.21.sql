SELECT
  upper(FIRSTNAME) "ИМЯ",
  (LASTNAME || substr(FIRSTNAME, 1, 1) || '. ' || substr(MIDDLENAME, 1, 1)||'.') as "Фамилия И. О."
FROM pers
WHERE FIRSTNAME LIKE '%м%' AND length(LASTNAME) < 7;