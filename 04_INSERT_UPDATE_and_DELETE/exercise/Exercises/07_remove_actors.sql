-- 7. Remove the actor appearances in "Avengers: Infinity War" (14 rows)
-- Note: Don't remove the actors themeselves, just make it so it seems no one appeared in the movie.

DELETE FROM movie_actor
USING movie
WHERE movie_actor.movie_id = movie.movie_id AND movie.title = 'Avengers: Infinity War';