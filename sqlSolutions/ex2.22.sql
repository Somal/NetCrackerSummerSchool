SELECT
  PERS_ID,
  DEPART_ID,
  FIRSTNAME,
  LASTNAME,
  MIDDLENAME,
  to_char(trunc(to_date('2010-' || to_char(HIRE_DATE, 'MM-DD'), 'YYYY-MM-DD'), 'MONTH'), 'YYYY-MM-DD') "HIREDATE",
  SALARY
FROM pers
WHERE to_char(HIRE_DATE, 'DD') < '05';
