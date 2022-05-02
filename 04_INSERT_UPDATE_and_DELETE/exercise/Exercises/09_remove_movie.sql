-- 9. Remove "Memento" from the movie table
-- You'll have to remove data from two other tables before you can remove it 
--(13 rows, 2 rows, 1 row)


DELETE FROM movie_actor
Where movie_id =(SELECT movie_id from movie where title = 'Memento');
Delete FROM movie_genre
Where movie_id = (SELECT movie_id from movie where title = 'Memento');
DELETE FROM movie WHERE title = 'Memento';

--work your way backwards to the deleting table