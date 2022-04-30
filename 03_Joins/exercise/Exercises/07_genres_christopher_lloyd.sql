-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.

select distinct genre_name
FROM genre
join movie_genre on genre.genre_id = movie_genre.genre_id
join movie on movie_genre.movie_id = movie.movie_id
join movie_actor on movie.movie_id = movie_actor.movie_id
join person on movie_actor.actor_id = person_id
WHERE person_name = 'Christopher Lloyd'
