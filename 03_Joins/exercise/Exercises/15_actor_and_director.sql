-- 15. The title of the movie and the name of director for movies where the 
--director was also an actor in the same movie (73 rows)

select m.title, p.person_name
from movie as m
join movie_actor as ma on ma.movie_id = m.movie_id
join person as p on p.person_id = ma.actor_id
where ma.actor_id = m.director_id;