-- 20. The state abbreviation, and population of the largest city (name column 'city_population') of all states, territories, and districts.
-- Order the results from highest to lowest populations.
-- (56 rows)
SELECT MAX(population) AS city_population, state_abbreviation FROM city GROUP BY state_abbreviation ORDER BY MAX(population) DESC;

--SELECT COUNT(state) AS num_states, census_region FROM state WHERE census_region IS NOT NULL GROUP BY census_region ORDER BY COUNT(state) DESC;

