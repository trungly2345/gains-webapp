
- Starting Docker container 
docker start pg-gains 

Accessing psql through docker 
docker exec -it pg-gains psql -U postgres -d gainsdb