CREATE TABLE rspoints(
r_id VARCHAR(5) PRIMARY KEY,
r_name VARCHAR(50),
r_location SDO_GEOMETRY,
r_phone VARCHAR(15)
);

INSERT INTO USER_SDO_GEOM_METADATA
VALUES ('rspoints', 'r_location', 
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X', 0, 600, 1), 
SDO_DIM_ELEMENT('Y', 0, 500, 1)), NULL);

CREATE INDEX rspoints_idx ON rspoints(r_location)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE TABLE rsensor(
r_id VARCHAR(5),
r_sensor VARCHAR(20),
constraint rsensor_pk primary key(r_id, r_sensor),
constraint rsensor_fk foreign key(r_id) references rspoints(r_id)
);

CREATE TABLE ptpoints(
p_id VARCHAR(5) PRIMARY KEY,
p_num VARCHAR(20),
p_location SDO_GEOMETRY,
p_name VARCHAR(20)
);

INSERT INTO USER_SDO_GEOM_METADATA
VALUES ('ptpoints', 'p_location', 
SDO_DIM_ARRAY(SDO_DIM_ELEMENT('X', 0, 600, 1), 
SDO_DIM_ELEMENT('Y', 0, 500, 1)), NULL);

CREATE INDEX ptpoints_idx ON ptpoints(p_location)
INDEXTYPE IS MDSYS.SPATIAL_INDEX;

CREATE TABLE psensor(
p_id VARCHAR(5),
p_sensor VARCHAR(20),
constraint psensor_pk primary key(p_id, p_sensor),
constraint psensor_fk foreign key(p_id) references ptpoints(p_id)
);



