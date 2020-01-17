CREATE TABLE TNETBANKING(NETBANKING_ID CHAR(3) PRIMARY KEY , USER_NAME VARCHAR(15) NOT NULL, PASSWORD VARCHAR(15) NOT NULL 
 );
CREATE TABLE TCARD(CARD_NO CHAR(12) PRIMARY KEY, CARD_HOLDER_NAME VARCHAR(15), CVV CHAR(3), EXPIRY_DATE VARCHAR(15));
CREATE TABLE TUPI(UPI_ID CHAR(12) PRIMARY KEY, PASSWORD VARCHAR(15));

CREATE TABLE TCUSTOMER_PAYMENT_MODES(CUSTOMER_ID CHAR(3), NETBANKING_ID CHAR(3), CARD_NO CHAR(12), UPI_ID CHAR(12),
CONSTRAINT FK_TNETBANKING FOREIGN KEY(NETBANKING_ID) REFERENCES TNETBANKING(NETBANKING_ID),
CONSTRAINT FK_TCARD FOREIGN KEY(CARD_NO) REFERENCES TCARD(CARD_NO), 
CONSTRAINT FK_TUPI FOREIGN KEY(UPI_ID) REFERENCES TUPI(UPI_ID)
);

select * from TCUSTOMER_PAYMENT_MODES;
select * from tcard;
select * from tupi;
select * from TNETBANKING;


insert into tcard values (
552738471263,'Albert Cho',555,'11/2020');

insert into tcard values(
738294738294,'Rohan Singh',267,'04/2023');

insert into tcard values(
17283962731,'Ravi Kiran',809,'08/2022');

insert into tcard values(
55271835255,'Kanha Bansal',777,'05/2021');

insert into tcard values(
552736835255,'Vivek Shah',232,'09/2024');


insert into tupi values(
'c01@oksbi','1234');

insert into tupi values(
'c02@oksbi','6543');

insert into tupi values(
'c03@oksbi','5652');

insert into tupi values(
'c04@oksbi','7766');

insert into tupi values(
'c05@oksbi','9292');

insert into tnetbanking values(
'C01','albert','1234');


insert into tnetbanking values(
'C02','rohan','8383');


insert into tnetbanking values(
'C03','ravi','9876');


insert into tnetbanking values(
'C04','kanha','7373');


insert into tnetbanking values(
'C05','vivek','1199');





insert into TCUSTOMER_PAYMENT_MODES values(
'C01','C01',552738471263,'c01@oksbi');


insert into TCUSTOMER_PAYMENT_MODES values(
'C02','C02',738294738294,'c02@oksbi');

insert into TCUSTOMER_PAYMENT_MODES values(
'C03','C03',17283962731,'c03@oksbi');

insert into TCUSTOMER_PAYMENT_MODES values(
'C04','C04',55271835255,'c04@oksbi');

insert into TCUSTOMER_PAYMENT_MODES values(
'C05','C05',552736835255,'c05@oksbi');