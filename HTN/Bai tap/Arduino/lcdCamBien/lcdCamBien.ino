#include <LiquidCrystal.h>
#include "DHT.h"

LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
int pingPin = 7;
int echoPin = 6;
long duration, distance;
const int DHTPIN = 1;
const int DHTTYPE = DHT11;
DHT dht(DHTPIN, DHTTYPE);
void setup() {
  lcd.begin(16, 2);
  pinMode(echoPin, INPUT);
  pinMode(pingPin, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(1, INPUT);
  dht.begin();
}
void loop() {
  digitalWrite(pingPin, LOW);
  delayMicroseconds(2);
  digitalWrite(pingPin, HIGH);
  delayMicroseconds(10);
  digitalWrite(pingPin, LOW);
  duration = pulseIn(echoPin, HIGH);
  distance = duration * 0.034 / 2; // 0.034= (340*100)/(10^6)
  lcd.setCursor(0, 0);
  lcd.print("distance: ");
  lcd.print(distance);
  if (distance < 150) {
    digitalWrite(10, HIGH);
  }
  else {
    digitalWrite(10, LOW);
  }
  lcd.print("cm");
  delay(100);

  float t = dht.readTemperature();
  lcd.setCursor(0, 1);
  lcd.print("nhiet do: ");
  lcd.print(t);
}
