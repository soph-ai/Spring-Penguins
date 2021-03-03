DROP TABLE IF EXISTS `penguin` CASCADE;
CREATE TABLE penguin (
    id BIGINT AUTO_INCREMENT,
    age INTEGER NOT NULL,
    name VARCHAR(255),
    no_of_children INTEGER NOT NULL,
    tuxedo_size INTEGER NOT NULL,
    PRIMARY KEY (id)
);