-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)

select title
FROM movie
join person on person.person_id = movie.director_id
join collection on movie.collection_id = collection.collection_id
WHERE collection_name = 'Star Wars Collection' AND person_name != 'George Lucas';
