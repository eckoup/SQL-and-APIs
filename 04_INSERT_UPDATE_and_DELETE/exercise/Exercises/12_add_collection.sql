-- 12. Create a "Bill Murray Collection" in the collection table. 
--For the movies that have Bill Murray in them, set their collection ID to the "Bill Murray Collection". 
--(1 row, 6 rows)

INSERT INTO collection (collection_name)
Values ('Bill Murray Collection');
UPDATE movie SET collection_id = (Select collection_id from Collection where collection_name like 'Bill Murray Collection')
Where movie_id in(Select movie_id FROM movie_actor WHERE actor_id=1532)

