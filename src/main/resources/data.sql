--Data seed sql script for initializing database

CREATE EXTENSION IF NOT EXISTS "uuid-ossp"; --Needed to auto gen uuid


INSERT INTO books (id, book_name, author, isbn)

VALUES
(
 1,
 'The Great Gatsby',
 'F. Scott Fitzgerald',
 '9780743273565'
),
(
 2,
 'The Hunger Games',
 'Suzanne Collins',
 '978-0439023481'
),
(
 3,
 'Eragon',
 'Christopher Paolini',
 '978-0375826696'
);