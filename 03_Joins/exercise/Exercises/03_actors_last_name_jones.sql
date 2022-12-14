-- 3. For all actors with the last name of "Jones", display the actor's name and movie titles they appeared in. Order the results by the actor names (A-Z). (48 rows)
SELECT person_name, title
FROM person
JOIN movie_actor on movie_actor.actor_id = person.person_id
JOIN movie on movie_actor.movie_id = movie.movie_id
WHERE person_name LIKE '% Jones' ORDER BY person_name;

