#include<reg51.h>
sbit Led=P1^0;        //Initializing Port-1 Pin#1 as Led

void delay(int value )   //Delay Function
{
int i,j;
 for(i=0;i<=value;i++)
 for(j=0;j<=5;j++);
}

void main()     //Main Function
{
P1=0x00;      //Initializing Port-1 as output

while(1){        //While loop continuously running the logic in it
Led=1;          //Led ON
delay(500);   //Delay for some time
Led=0;         //Led Off
delay(500);  //Delay for some time
}

}