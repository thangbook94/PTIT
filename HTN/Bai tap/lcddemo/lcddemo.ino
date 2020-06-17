/*
   LCD RS pin to digital pin 12
   LCD Enable pin to digital pin 11
   LCD D4 pin to digital pin 5
   LCD D5 pin to digital pin 4
   LCD D6 pin to digital pin 3
   LCD D7 pin to digital pin 2
   LCD R/W pin to ground
   LCD VSS pin to ground
   LCD VCC pin to 5V
   10K resistor:
*/

#include <LiquidCrystal.h>

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);

void setup() {
  pinMode(13, INPUT);
  lcd.begin(16, 2);
}

void loop() {
  if (digitalRead(13) == HIGH) {
    lcd.setCursor(0, 0);
    lcd.print("n.dinh thang");
    delay(1000);
    //    lcd.clear();
    lcd.setCursor(0, 1);
    lcd.print("b16dccn319");
  }
}
