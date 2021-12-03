INSERT INTO phonebook.contact (contact_type, nickname, phone_number) VALUES ('FAVOURITE', 'honey', '0936483975');
INSERT INTO phonebook.contact (contact_type, nickname, phone_number) VALUES ('FAMILY', 'mom', '0123465789');
INSERT INTO phonebook.contact (contact_type, nickname, phone_number) VALUES ('SCHOOL', 'Alice', '0785422122');
INSERT INTO phonebook.contact (contact_type, nickname, phone_number) VALUES ('JOB', 'boss', '0123321123');
INSERT INTO phonebook.contact (contact_type, nickname, phone_number) VALUES ('JOB', 'Bob', '0987123123');

INSERT INTO phonebook.personal_info (birth_day, first_name, last_name, contact_id) VALUES ('1995-11-11', 'Jinny', 'Wood', '1');
INSERT INTO phonebook.personal_info (birth_day, first_name, last_name, contact_id) VALUES ('1983-10-09', 'Anna', 'Johns', '2');
INSERT INTO phonebook.personal_info (birth_day, first_name, contact_id) VALUES ('1999-12-15', 'Ben', '3');
INSERT INTO phonebook.personal_info (birth_day, first_name, last_name, contact_id) VALUES ('1880-02-04', 'Bob', 'Fichman', '4');

INSERT INTO phonebook.method_of_communication (communication_type, description, number, contact_id) VALUES ('EMAIL ', 'some description', 'bob@gmail.com', '1');
INSERT INTO phonebook.method_of_communication (communication_type, description, number, contact_id) VALUES ('HOME_NUMBER', 'some description', '24270', '1');
INSERT INTO phonebook.method_of_communication (communication_type, number, contact_id) VALUES ('WORK_NUMBER', '3933992255', '1');
INSERT INTO phonebook.method_of_communication (communication_type, description, number, contact_id) VALUES ('SKYPE', 'some description', '32521', '2');
INSERT INTO phonebook.method_of_communication (communication_type, number, contact_id) VALUES ('HOME_NUMBER', '54564257', '2');
INSERT INTO phonebook.method_of_communication (communication_type, description, number, contact_id) VALUES ('HOME_NUMBER', 'some description', '575454', '3');
INSERT INTO phonebook.method_of_communication (communication_type, number, contact_id) VALUES ('SKYPE', '5454521', '3');
INSERT INTO phonebook.method_of_communication (communication_type, description, number, contact_id) VALUES ('SKYPE', 'some description', '875445', '3');

INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('30000000000', '2021-12-03 10:23:21.268836', 'OUTPUT', '2', '1');
INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('560000000000', '2021-12-03 10:23:21.268836', 'OUTPUT', '3', '1');
INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('600000000000', '2021-12-03 10:23:21.268836', 'INPUT', '2', '3');
INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('0', '2021-12-03 10:23:21.268836', 'MISSED', '2', '2');
INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('0', '2021-11-03 10:23:21.268836', 'MISSED', '2', '1');
INSERT INTO phonebook.our_call (duration, time, type, from_contact_id, to_contact_id) VALUES ('500000000000', '2021-12-03 10:23:21.268836', 'OUTPUT', '3', '4');

