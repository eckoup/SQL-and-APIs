-- 6. The genres of "The Wizard of Oz" (3 rows)

SELECT genre_name
FROM genre
JOIN movie_genre on movie_genre.genre_id = genre.genre_id
Join movie on movie.movie_id = movie_genre.movie_id
Where title = 'The Wizard of Oz' order by title DESC;



