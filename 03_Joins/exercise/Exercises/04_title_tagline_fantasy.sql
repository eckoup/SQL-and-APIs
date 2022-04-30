-- 4. The titles and taglines of all the movies that are in the Fantasy genre. Order the results by title (A-Z) (81 rows)
--REMEMBER: from table_1 join table_2 on table1.primary_id = table2.foreign_id;

SELECT title, tagline
FROM movie
JOIN movie_genre on movie_genre.movie_id = movie.movie_id
JOIN genre on genre.genre_id = movie_genre.genre_id
WHERE genre_name = 'Fantasy' ORDER BY title;
