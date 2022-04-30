-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person_name, birthday FROM person 
Join movie_actor on person.person_id = movie_actor.actor_id
Join movie on movie.movie_id=movie_actor.movie_id
WHERE movie.title = 'The Fifth Element';

--REMEMBER: from table_1 join table_2 on table1.primary_id = table2.foreign_id;