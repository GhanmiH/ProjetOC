
 CREATE TABLE fire_station (
 id INT AUTO_INCREMENT  PRIMARY KEY,
 address VARCHAR(250) NOT NULL,
station INT NOT NULL
);
INSERT INTO fire_station (address,station) VALUES ('1509 Culver St',3),
    ('29 15th St',2),
    ('834 Binoc Ave',3) ,
    ('644 Gershwin Cir',1),
    ('748 Townings Dr',3),
    ('112 Steppes Pl',3),
    ('489 Manchester St',4) , 
    ('892 Downing Ct',2),
    ('908 73rd St',1),
    ('112 Steppes Pl',4),
    ('947 E. Rose Dr',1),
    ('748 Townings Dr',3) ,
    ('951 LoneTree Rd',2); 
  
CREATE TABLE medical_record (
      Id INT AUTO_INCREMENT  PRIMARY KEY,
      First_name VARCHAR(250) NOT NULL,
      last_name VARCHAR(250) NOT NULL,
      Birthdate Date NOT NULL
      );
  
INSERT INTO medical_record (First_name, Last_name, Birthdate) VALUES
        ( 'John','Boyd','1984-03-06'),
        ( 'Jacob','Boyd','1989-03-06'),
        ( 'Tenley','Boyd','2012-02-18'),
        ( 'Roger','Boyd','2017-09-06'),
        ( 'Felicia','Boyd','1986-01-08'),
        ( 'Jonanathan','Marrack','1989-01-03'),
        ( 'Tessa','Carman','2012-02-18'),
        ( 'Peter','Duncan','2000-09-06'),
        ( 'Foster','Shepard','1980-01-08'),
        ( 'Tony','Cooper','1994-03-06'),
        ( 'Lily','Cooper','1994-03-06'),
        ( 'Sophia','Zemicks','1988-03-06'),
        ( 'Warren','Zemicks','1985-03-06'),
        ( 'Zach','Zemicks','2017-03-06'),
        ( 'Reginold','Walker','1979-08-30'),
        ( 'Jamie','Peters','1982-03-06'),
        ( 'Ron','Peters','1965-04-06'),
        ( 'Allison','Boyd','1965-03-15'),
        ( 'Brian','Stelzer','1975-12-06'),
        ( 'Shawna','Stelzer','1980-07-08'),
        ( 'Kendrik','Stelzer','2014-03-06'),
        ( 'Clive','Ferguson','1994-03-06'),
        ( 'Eric','Cadigan','1945-08-06');
        
CREATE TABLE allergies  (
        allergie_id  INT AUTO_INCREMENT  PRIMARY KEY,
        allergie VARCHAR(250) NOT NULL
         );
INSERT INTO allergies (allergie) VALUES
               ('nillacilan'),
               ('peanut'),
               ('xilliathal'),
               ('shellfish'),
               ('aznol'),
               ('illisoxian');
  
CREATE TABLE medications  (
        medication_id  INT AUTO_INCREMENT  PRIMARY KEY,
         medication VARCHAR(250) NOT NULL
         );
INSERT INTO medications (medication) VALUES
               ('aznol:350mg'),
               ('hydrapermazol:100mg'),
               ('pharmacol:5000mg'),
               ('terazine:10mg'),
               ('noznazol:250mg'),
               ('tetracyclaz:650mg'),
               ('hydrapermazol:300mg'),
               ('dodoxadin:30mg'),
               ('aznol:60mg'),
               ('hydrapermazol:900mg'),
               ('pharmacol:5000mg'),
               ('terazine:500mg'),
               ('thradox:700mg'),
               ('aznol:200mg'),
               ('ibupurin:200mg'),
               ('hydrapermazol:400mg'),
               ('noxidian:100mg'),
               ('pharmacol:2500mg'),
               ('tradoxidine:400mg');
  
CREATE TABLE medical_record_allergies  (
         medical_record_id  INT AUTO_INCREMENT  PRIMARY KEY,
         id_medical_record int ,
         id_allergie int
         );
INSERT INTO medical_record_allergies (id_medical_record,id_allergie) VALUES
               (1,1),(2,null),(3,2), (4,null), (5,3), (6,null), (7,null),(8,4), (9,null), (10,4), (11,null),
               (12,2),(12,4),(12,5), (13,null), (14,null), (15,6), (16,null), (17,null), (18,1), (19,1), (20,null), (21,null),
               (22,null), (23,null);
             
 CREATE TABLE medical_record_medications  (
        medical_record_medications_id  INT AUTO_INCREMENT  PRIMARY KEY,
        id_medical_record int ,
       id_medication int
       );
INSERT INTO medical_record_medications (id_medical_record, id_medication) VALUES
              (1,1), (1,2), (2,3),(2,4), (2,5), (3,null), (4,null), (5,6), (6,null), (7,null),(8,null), (9,null),(10,7),(10,8), (11,null),
             (12,9),(12,10),(12,11),(12,12), (13,null), (14,null), (15,13), (16,null), (17,null), (18,14), (19,15), (19,16), (20,null), 
             (21,17), (21,18),(22,null), (23,19); 
                  
CREATE TABLE person (
  id  INT AUTO_INCREMENT  PRIMARY KEY,
  First_name VARCHAR(250) NOT NULL,
  last_name VARCHAR(250) NOT NULL,
  address VARCHAR(250) NOT NULL,
  city VARCHAR(250) NOT NULL,
  zip INT NOT NULL,
  phone VARCHAR(250) NOT NULL,
  email VARCHAR(250) NOT NULL
);

INSERT INTO person (First_name, Last_name, address, city, zip, phone, email) VALUES    
       ('John', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com' ),
        ('Jacob', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6513', 'drk@email.com' ),
        ('Tenley', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'tenz@email.com' ),
        ('Roger', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com' ),
        ('Felicia', 'Boyd', '1509 Culver St', 'Culver', 97451, '841-874-6544', 'jaboyd@email.com' ),
        ('Jonanathan', 'Marrack', '29 15th St', 'Culver', 97451, '841-874-6513', 'drk@email.com' ),
        ('Tessa', 'Carman', '834 Binoc Ave', 'Culver', 97451, '841-874-6512', 'tenz@email.com' ),
        ('Peter', 'Duncan', '644 Gershwin Cir', 'Culver', 97451, '841-874-6512', 'jaboyd@email.com' ),
        ('Foster', 'Shepard', '748 Townings Dr', 'Culver', 97451, '841-874-6544', 'jaboyd@email.com' ),
        ('Tony', 'Cooper', '112 Steppes Pl', 'Culver', 97451, '841-874-6874', 'tcoop@ymail.com' ),
        ('Lily', 'Cooper', '489 Manchester St', 'Culver', 97451, '841-874-9845', 'lily@email.com' ),
        ('Sophia', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7878', 'soph@email.com' ),
        ('Warren', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7512', 'ward@email.com' ),
        ('Zach', 'Zemicks', '892 Downing Ct', 'Culver', 97451, '841-874-7512', 'zarc@email.com' ),
        ('Reginold', 'Walker', '908 73rd St', 'Culver', 97451, '841-874-8547', 'reg@email.com' ),
        ('Jamie', 'Peters', '908 73rd St', 'Culver', 97451, '841-874-7462', 'jpeter@email.com' ),
        ('Ron', 'Peters', '112 Steppes Pl', 'Culver', 97451, '841-874-8888', 'jpeter@email.com' ),
        ('Allison', 'Boyd', '112 Steppes Pl', 'Culver', 97451, '841-874-9888', 'aly@imail.com' ),
        ('Brian', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'bstel@email.com' ),
        ('Shawna', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'ssanw@email.com' ),
        ('Kendrik', 'Stelzer', '947 E. Rose Dr', 'Culver', 97451, '841-874-7784', 'bstel@email.com' ),
        ('Clive', 'Ferguson', '748 Townings Dr', 'Culver', 97451, '841-874-6741', 'clivfd@ymail.com' ),
        ('Eric', 'Cadigan', '951 LoneTree Rd', 'Culver', 97451, '841-874-7458', 'gramps@email.com' );
        
       
       