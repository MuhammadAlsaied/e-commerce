
CREATE TABLE category(
    id identity primary key auto_increment,
    name varchar(200),
    desc varchar(500),
    image_url varchar(300),
    is_active boolean
)