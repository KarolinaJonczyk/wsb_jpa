insert into address (id, address_line1, address_line2, city, postal_code)
            values (1, 'xx', 'yy', 'city', '62-030'),
            (2, 'Legnicka 1', 'Fabryczna', 'Wroclaw', '54-129'),
            (3, 'Rynek 2', 'Stare Miasto', 'Wroclaw', '50-106'),
            (4, 'Lisia Grobla 7', 'Srodmiescie', 'Gdansk', '80-860');

insert into patient (id, first_name, last_name, telephone_number, email, date_of_birth, patient_number, verified, day_off)
            values (1, 'Marcin', 'Maj', '123456789', 'mmaj@mail.com', '1998-05-05', '0000125', true, 0),
            (2, 'Kamila', 'Kwiecien', '132465798', 'kkwiecien@mail.com', NULL, '0000016', true, 12),
            (3, 'Ludwik', 'Ladny', '231564897', 'l.ladny@mail.com', '1987-02-14', '0003125', false, 10),
            (4, 'Klementyna', 'Kot', '321654987', NULL, '2005-06-01', '0010001', true, 16);

insert into doctor (id, first_name, last_name, specialization, telephone_number, email, doctor_number)
    values (1, 'Alojzy', 'Zdrowy', 'Orthopedist', '456123789','dr.ortho@mail.com', '1'),
    (2, 'Hanna', 'Kolano', 'Dentist', '465312798', 'dr.dentist@mail.com', '2'),
    (3, 'Antoni', 'Glodny', 'Gastroenterologist', '332665998', 'dr.gastro-ent@mail.com', '3'),
    (4, 'Franciszka', 'Geniusz', 'Neurologist', '221554887', 'dr.neuron@mail.com', '4');

insert into visit (id, description, time, doctor_id, patient_id)
            values (1, 'wisdom tooth extraction', '2024-05-02 12:30:00', 2, 1),
                   (2, 'treatment of a sprained ankle', '2020-12-01 12:00:00', 1, 2),
                   (3, 'referral for Helicobacter pylori testing', '2021-10-30 12:00:00', 3, 4),
                   (4, 'migraine treatment', '2023-01-12 12:00:00', 4, 3);

   insert into medical_treatment (id, description, visit_id)
               values (1, 'treatment', 1),
                      (2, 'RTG', 2),
                      (3, 'consultation', 3),
                      (4, 'USG', 4);
