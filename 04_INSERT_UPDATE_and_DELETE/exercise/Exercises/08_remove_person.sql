-- 8. Remove "Penn Jillette" from the person table 
-- You'll have to remove data from another table before you can make him "disappear" 
--(Get it? Because he's a magician...) (1 row each)

DELETE FROM movie_actor
WHERE actor_id = (Select person_id from person where person_name = 'Penn Jillette');
DELETE from person where person_name = 'Penn Jillette';

--work your way backwards to the deleting table

