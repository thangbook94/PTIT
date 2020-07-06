void setup() {
  pinMode(1, OUTPUT);
  pinMode(2, OUTPUT);
  pinMode(3, OUTPUT);
  pinMode(4, OUTPUT);
  pinMode(5, OUTPUT);
  pinMode(6, OUTPUT);
  pinMode(7, OUTPUT);
  pinMode(8, OUTPUT);
  pinMode(9, OUTPUT);
  pinMode(10, OUTPUT);
  pinMode(11, OUTPUT);
  pinMode(0, OUTPUT);

}

void loop() {
  blink();
  delay(500);
  runForward();
  delay(500);
  runBackward();
  for (int i = 0; i < 3; i++) {
    blink();
  }
  delay(60000);
}

void blink() {
  for (int i = 0; i < 12; i++) {
    digitalWrite(i, HIGH);
  }
  delay(500);
  for (int i = 0; i < 12; i++) {
    digitalWrite(i, LOW);
  }
  delay(500);
}
void runForward() {
  for (int i = 0; i < 12; i++) {
    digitalWrite(i, HIGH);
    delay(200);
    digitalWrite(i, LOW);
  }
  digitalWrite(0, HIGH);
  delay(200);
  digitalWrite(0, LOW);
}
void runBackward() {
  delay(200);
  digitalWrite(0, HIGH);
  delay(200);
  digitalWrite(0, LOW);
  for (int i = 11; i >= 0; i--) {
    digitalWrite(i, HIGH);
    delay(200);
    digitalWrite(i, LOW);
  }
}
