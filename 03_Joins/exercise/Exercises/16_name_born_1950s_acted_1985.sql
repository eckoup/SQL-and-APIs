-- 16. The names and birthdays of actors born in the 1950s who acted in 
--movies that were released in 1985 (20 rows)

SELECT DISTINCT person_name, birthday
FROM person
JOIN movie_actor on person.person_id = movie_actor.actor_id
JOIN movie on movie_actor.movie_id = movie.movie_id
WHERE birthday between '01-01-1950' AND '12-31-1959' AND
release_date between '01-01-1985' AND '12-31-1985' order by person_name, birthday limit 20;