#include <Stepper.h>
Stepper stepper(100, 8, 9, 10, 11);
const int pot = A0;
void setup()
{
}
int direction_ = 0, speed_ = 0;
void loop()
{
    int val = analogRead(pot);
    if ( speed_ != map(val, 0, 1023, 1, 100) )
    {
      speed_ = map(val, 0, 1023, 1, 100);
      stepper.setSpeed(speed_);
    }
  stepper.step(direction_);
  delay(10000000);
}
