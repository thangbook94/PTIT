

byte row[8]={0x01,0x02,0x04,0x08,0x10,0x20,0x40,0x80};

byte chuHex[][8] ={
{0xFF,0xF9,0xFD,0x01,0x01,0xFD,0xF9,0xFF},//T
};

void setup() {
  
  pinMode(4,OUTPUT);
  pinMode(13,OUTPUT);
  pinMode(12,OUTPUT);
  pinMode(3,OUTPUT);
  pinMode(11,OUTPUT);
  
}

void loop() {
  for(int i=0;i<8;i++)
  {
    digitalWrite(11,0);
    shiftOut(12,13,MSBFIRST,row[i]);
    shiftOut(3,4,MSBFIRST,chuHex[0][i]);
    digitalWrite(11,1);
  }
}
