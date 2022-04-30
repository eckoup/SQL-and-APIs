-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows)

select Distinct person_name
FROM person
Join movie on movie.director_id = person.person_id
Join collection on collection.collection_id = movie.collection_id
WHERE collection_name LIKE 'Harry Potter Collection';