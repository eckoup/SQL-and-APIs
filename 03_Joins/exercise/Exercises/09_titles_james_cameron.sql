-- 9. The titles of movies directed by James Cameron (6 rows)

select title
FROM movie
join person on movie.director_id= person.person_id
WHERE person_name = 'James Cameron' order by director_id DESC;