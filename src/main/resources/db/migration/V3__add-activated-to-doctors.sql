alter table doctors add activated tinyint;
update doctors set activated = 1;