#include "RTClib.h"
byte row[8] = {0x01, 0x02, 0x04, 0x08, 0x10, 0x20, 0x40, 0x80};
byte chuHex[][8] = {
  {0xFF, 0x83, 0x01, 0x6D, 0x75, 0x01, 0x83, 0xFF}, //0
  {0xFF, 0x7F, 0x77, 0x01, 0x01, 0x7F, 0x7F, 0xFF}, //1
  {0xFF, 0x3B, 0x19, 0x5D, 0x6D, 0x61, 0x73, 0xFF}, //2
  {0xFF, 0xBB, 0x39, 0x6D, 0x6D, 0x01, 0x93, 0xFF}, //3
  {0xFF, 0xCF, 0xD7, 0xDB, 0x01, 0x01, 0xDF, 0xFF}, //4
  {0xFF, 0xB1, 0x31, 0x75, 0x75, 0x05, 0x8D, 0xFF}, //5
  {0xFF, 0x83, 0x01, 0x6D, 0x6D, 0x09, 0x9B, 0xFF}, //6
  {0xFF, 0xF9, 0xF9, 0x1D, 0x05, 0xE1, 0xF9, 0xFF}, //7
  {0xFF, 0x93, 0x01, 0x6D, 0x6D, 0x01, 0x93, 0xFF}, //8
  {0xFF, 0xB3, 0x21, 0x6D, 0x6D, 0x01, 0x83, 0xFF}, //9
};
byte led[][8] = {0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF, 0xFF};
int a, b, c, d, e, f;
RTC_DS1307 rtc;

int time;
void setup() {
  time = 0;
  DateTime now = rtc.now();
  a = (int)now.hour() / 10;
  b = (int)now.hour() % 10;
  c = (int)now.minute() / 10;
  d = (int)now.minute() % 10;
  e = (int)now.second() / 10;
  f = (int)now.second() % 10;
  pinMode(12, OUTPUT);
  pinMode(13, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(0, OUTPUT);
  pinMode(1, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(A1, OUTPUT);
  pinMode(A4, INPUT);
  pinMode(A5, INPUT);
}
void loop() {

  if (millis() > 1000 * time) {
    add();
    time = time + 1;
  } else {
    for (int i = 0; i < 8; i++)
    {
      digitalWrite(11, LOW);
      shiftOut(12, 13, MSBFIRST, row[i]); // dataPin, clockPin, bitOrder, value
      shiftOut(9, 10, MSBFIRST, chuHex[a][i] );
      shiftOut(7, 8, MSBFIRST, chuHex[b][i] );
      shiftOut(5, 6, MSBFIRST, chuHex[c][i] );
      shiftOut(3, 4, MSBFIRST, chuHex[d][i] );
      shiftOut(1, 2, MSBFIRST, chuHex[e][i] );
      shiftOut(A1, 0, MSBFIRST, chuHex[f][i] );
      digitalWrite(11, HIGH);
    }
  }



}
void add() {
  f++;
  if (f >= 10) {
    f = f % 10;
    e++;
  }
  if (e >= 6) {
    e = e % 6;
    d++;
  }
  if (d >= 10) {
    d = d % 10;
    c++;
  }
  if (c >= 6) {
    c = c % 6;
    b++;
  }
  if (b >= 10) {
    b = b % 10;
    a++;
  }
  if (a == 2 && b == 4) {
    a = 0;
    b = 0;
  }
}
void Blink()
{
  digitalWrite(13, !digitalRead(13)); //trình phục vụ ngắt
}
