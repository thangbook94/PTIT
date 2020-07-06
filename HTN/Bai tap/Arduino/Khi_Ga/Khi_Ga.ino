#include <Wire.h>
int gas = 6;
int led = 8;
void setup() {
  pinMode(gas, INPUT);
  pinMode(led, OUTPUT);
}
void loop() {
  if (digitalRead(gas) == HIGH)
  {
    digitalWrite(led, HIGH);
  }
  else
  {
    digitalWrite(led, LOW);
  }
}
