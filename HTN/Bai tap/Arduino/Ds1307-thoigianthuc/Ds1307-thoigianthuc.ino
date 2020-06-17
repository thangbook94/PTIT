#include <LiquidCrystal.h>
#include <Wire.h>

// initialize the library with the numbers of the interface pins
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup() {
  lcd.begin(16, 2);
  Wire.begin(); 
}
char Time[]     = "TIME:  :  :  ";
char Date[] = "DATE:  /  /20  ";
byte i, second, minute, hour, date, month, year;
 
void DS1307_display(){
  // Convert BCD to decimal
  second = (second >> 4) * 10 + (second & 0x0F);
  minute = (minute >> 4) * 10 + (minute & 0x0F);
  hour   = (hour >> 4)   * 10 + (hour & 0x0F);
  date   = (date >> 4)   * 10 + (date & 0x0F);
  month  = (month >> 4)  * 10 + (month & 0x0F);
  year   = (year >> 4)   * 10 + (year & 0x0F);
  // End conversion
  Time[12]     = second % 10 + 48;
  Time[11]     = second / 10 + 48;
  Time[9]      = minute % 10 + 48;
  Time[8]      = minute / 10 + 48;
  Time[6]      = hour   % 10 + 48;
  Time[5]      = hour   / 10 + 48;
  Date[14] = year   % 10 + 48;
  Date[13] = year   / 10 + 48;
  Date[9]  = month  % 10 + 48;
  Date[8]  = month  / 10 + 48;
  Date[6]  = date   % 10 + 48;
  Date[5]  = date   / 10 + 48;
  lcd.setCursor(0, 0);
  lcd.print(Time);                              
  lcd.setCursor(0, 1);
  lcd.print(Date);                          
}

 
void loop() {
    Wire.beginTransmission(0x68);                 // Start I2C protocol with DS1307 address
    Wire.write(0);                                // Send register address
    Wire.endTransmission(false);                  // I2C restart
    Wire.requestFrom(0x68, 7);                    // Request 7 bytes from DS1307 and release I2C bus at end of reading
    second = Wire.read();                         // Read seconds from register 0
    minute = Wire.read();                         // Read minuts from register 1
    hour   = Wire.read();                         // Read hour from register 2
    Wire.read();                                  
    date   = Wire.read();                         // Read date from register 4
    month  = Wire.read();                         // Read month from register 5
    year   = Wire.read();                         // Read year from register 6
    DS1307_display();                             // Diaplay time & calendar
    delay(50);                                    // Wait 50ms
}
