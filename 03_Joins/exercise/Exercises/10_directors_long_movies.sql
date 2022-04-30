-- 10. The names of directors who have directed a movie over 3 hours [180 minutes] (15 rows)

select distinct person_name
FROM person
join movie on person.person_id = movie.director_id
WHERE length_minutes > 180;