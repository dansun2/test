CREATE DATABASE IF NOT EXISTS library;
USE library;

CREATE TABLE users (
    user_no INT PRIMARY KEY COMMENT '이용자 번호',
    user_name VARCHAR(100) NOT NULL COMMENT '이름', 
    user_address VARCHAR(255) COMMENT '주소',
    user_phone VARCHAR(20) COMMENT '휴대폰번호',
    user_status VARCHAR(20) COMMENT '상태'
);

CREATE TABLE books (
    book_code INT PRIMARY KEY COMMENT '도서 번호',
    book_title VARCHAR(255) NOT NULL COMMENT '제목',
    book_quantity INT COMMENT '수량',
    book_status VARCHAR(20) COMMENT '상태'
);

CREATE TABLE rentals (
    rental_id INT PRIMARY KEY AUTO_INCREMENT COMMENT '대여 번호',
    user_no INT COMMENT '이용자 번호',
    book_code INT COMMENT '도서 번호',
    rental_date DATE COMMENT '대여일',
    FOREIGN KEY (user_no) REFERENCES users(user_no),
    FOREIGN KEY (book_code) REFERENCES books(book_code)
);

-- 예시 데이터 삽입
INSERT INTO users (user_no, user_name, user_address, user_phone, user_status) VALUES
(1, '홍길동', '서울시 강남구', '010-1234-5678', 'active'),
(2, '김철수', '부산시 해운대구', '010-8765-4321', 'inactive');

INSERT INTO books (book_code, book_title, book_quantity, book_status) VALUES
(101, '데이터베이스 시스템', 5, 'available'),
(102, '자바 프로그래밍', 3, 'available');

INSERT INTO rentals (user_no, book_code, rental_date) VALUES
(1, 101, '2023-06-01'),
(2, 102, '2023-06-02');
