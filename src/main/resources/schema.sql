DROP TABLE IF EXISTS HotelBooking;  
CREATE TABLE HotelBooking (  
booking_id INT AUTO_INCREMENT  PRIMARY KEY,  
guest_name VARCHAR(100) NOT NULL,  
room_number VARCHAR(10) NOT NULL,  
booking_date DATE NOT NULL  
);  

