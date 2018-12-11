insert into public.directors (first_name,last_name) values ('Alfred','Hitchcock'),('Jack', 'Clayton'),('David', 'Lean'), ('Michael','Cimino');
insert into public.movies(title, year, length) Values('Avatar', '2009-01-12',162),('Annie Hall','1977-12-01',93),('Braveheart','1995-2-12',123), ('Chinatown','1974-10-02)', 132);
insert into public.genres values(1, 'Fire everywhere', 'Action'), (2,'Drama description', 'Drama'),(3,'Description', 'Romance');
insert into public.movies_genres values (1,1), (2,2), (3,3), (4,1);

-- select * from public.directors;
-- select * from public.movies_genres;
-- select * from public.genres;
-- select * from public.movies;