-- 19. The genre name and the number of movies in each genre. 
--Name the count column 'num_of_movies'. 
-- (19 rows, expected result for Action is around 180).

SELECT g.genre_name, COUNT(m.title) as "num_of_movies"
FROM movie m
JOIN movie_genre mg using (movie_id)
JOIN genre g USING (genre_id)
GROUP BY g.genre_name