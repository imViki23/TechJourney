INSERT INTO courses (id, name) VALUES ('ECE', 'Electronics and Communication Engineering');
INSERT INTO courses (id, name) VALUES ('MECH', 'Mechanical Engineering');
INSERT INTO courses (id, name) VALUES ('CSE', 'Computer Science Engineering');

INSERT INTO students (id, name, course_id) VALUES (100001, 'Neduncheliyan', 'ECE');
INSERT INTO address (id, area, pin_code) VALUES (100001, 'Thanjai', '234566');
INSERT INTO assets(name, category, student_id) VALUES ('HP Pavilion 15', 'LAPTOP', 100001);
INSERT INTO assets(name, category, student_id) VALUES ('HP Pavilion Keyboard 1', 'KEYBOARD', 100001);

INSERT INTO students (id, name, course_id) VALUES (100002, 'karikalan', 'MECH');
INSERT INTO address (id, area, pin_code) VALUES (100002, 'Theni', '453567');
INSERT INTO assets(name, category, student_id) VALUES ('Dell Mouse 13', 'MOUSE', 100002);