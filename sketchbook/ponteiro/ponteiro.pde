#include <stdio.h>
#include <math.h>

 typedef struct lista {
     int num;
     struct lista *prox;
 } data;

data *no;
data *head; 
data *aux; 
int  cont = 0;

void setup() {                
  
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  pinMode(12, OUTPUT);
  no = (data*)malloc( sizeof(data) );
  no->prox = NULL;
  head = (data*)malloc( sizeof(data) );
  head->prox = NULL;
 
  
}

void loop() {
 
   while(cont < 10){
     
    
     if(head->prox == NULL){
        digitalWrite(13, HIGH);   // set the LED on
        delay(1000);
        digitalWrite(13, LOW);
        delay(1000);
        head->prox = no;
        no->num = ++cont; 
       
     }else{
         digitalWrite(13, HIGH);   // set the LED on
         delay(1000);
         digitalWrite(13, LOW);
         delay(1000);
         data *proxno;
         proxno = (data*)malloc( sizeof(data) );
         proxno->num = ++cont;
         no->prox = proxno;
         proxno->prox = NULL;
         no = proxno;
     }     
   }
   aux = head->prox;
   while(aux != NULL){
      
     digitalWrite(12, HIGH);   // set the LED on
     delay(1000);
     digitalWrite(12, LOW);
     delay(1000);
     Serial.println(aux->num);
     aux = aux->prox;
     
   }
   
   
}
