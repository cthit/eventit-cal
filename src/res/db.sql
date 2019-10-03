CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

CREATE TABLE event (
    id uuid DEFAULT uuid_generate_v4 (),
    name VARCHAR NOT NULLABLE,
    date DATE NOT NULLABLE,
    start_time DATE NOT NULLABLE,
    end_time DATE NOT NULLABLE,
    description VARCHAR NULLABLE,
    organizer VARCHAR NULLABLE,
    contact VARCHAR NULLABLE
)