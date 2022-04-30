-- 11. The titles of the movies in the "Star Wars Collection" 
--ordered by release date, most recent to earliest (9 rows)

select title
FROM movie
Join collection on movie.collection_id = collection.collection_id
WHERE collection_name = 'Star Wars Collection' order by release_date DESC;

