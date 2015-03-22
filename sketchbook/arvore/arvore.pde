#include <stdio.h>
#include <math.h>
#include "no.h"

int insere(int a, data *no, data *raiz){
  
     Serial.println("insere");          
     if(no->num <= raiz->num){
        
        if(raiz->proxdir == NULL){
           raiz->proxdir = no;  
           return a;      
        }else{
           insere(a,no,raiz->proxdir); 
        }
        
     }else{
       
        if(raiz->proxesq == NULL){
           raiz->proxesq = no; 
           return a;       
        }else{
           insere(a,no,raiz->proxesq); 
        }        
     }
     
}

void emordem(data *raiz){
  
  emordem(raiz->proxdir);
  digitalWrite(9, HIGH);   
  delay(1000);
  digitalWrite(9, LOW);
  delay(1000);
  Serial.println("OI");
  emordem(raiz->proxesq);

}
  

//int  cont = 0;
int retorno;
data *raiz = (data*)malloc( sizeof(data) );

void setup() {  
  
  Serial.begin(9600);
  pinMode(13, OUTPUT);
  pinMode(9,OUTPUT);
      
}

void loop() {
 
   
           
   while(cont <= 10){
   
     if(teste == 0){
       
        digitalWrite(13, HIGH);
        delay(1000);
        digitalWrite(13, LOW);
        delay(1000);
        Serial.println("raiz");
        raiz->num = analogRead(0);
        raiz->proxdir = NULL;
        raiz->proxesq = NULL;
        teste = 1; 
        
     }else{
         digitalWrite(13, HIGH);
         delay(1000);
         digitalWrite(13, LOW);
         delay(1000);         
         data *proxno;
         proxno = (data*)malloc( sizeof(data) );
         proxno->num = analogRead(0);
         proxno->proxdir = NULL;
         proxno->proxesq = NULL;
         cont = insere(cont, proxno,raiz);
         Serial.println(cont);         
     }
     cont++; 
     Serial.println(cont);    
   }
   cont = 10;
   emordem(raiz);
  
}

