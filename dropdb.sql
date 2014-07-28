DROP INDEX rspoints_idx;
DROP INDEX ptpoints_idx;

DELETE FROM USER_SDO_GEOM_METADATA;
commit;

DROP TABLE rsensor;
DROP TABLE psensor;
DROP TABLE ptpoints;
DROP TABLE rspoints;

