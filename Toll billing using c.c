#include<stdio.h>
#include<conio.h>
#include<stdlib.h>
#include<string.h>
typedef struct vehicles
{
	char vehicle_no[100];
	char vehicle_class[100];
	char section[150];
	int fare_amount;
	int Lane_no;
	struct vehicles *next;
}vehicles;
vehicles *first =NULL;
void login()
 {
	int i=0,j=0;
	char EN_uname[10];
	char EN_pass[10],z=' ';
	char uname[10]="chethan";
	char pass[10]="chrm";
	
	do 
	{
		printf("\n    ********** LOGIN ************");
		printf("\n    ********** YOU HAVE TWO CHANCES ***********");
		printf("\n ENTER THE USERNAME:");
		scanf("%s",&EN_uname);
		
		printf("\n ENTER PASSWORD:");
		 
		 while(i<10)
		 {
		 	EN_pass[i]=getch();
		 	z=EN_pass[i];
		 	if(z==13)
		 	{
		 		 break;
		 	
			 }
			 else
			 {
			 	printf("*");
			 }
			 i++;
			 
		 }
		 EN_pass[i]='\0';
		 i=0;
		 if(strcmp(EN_uname,uname)==0&&strcmp(EN_pass,pass)==0)
		 {
		 	printf("\n ********LOGIN IS SUCCESFUL********");
		 	printf("\n ********WELCOME TO HOSAKOTE TOLL PLAZA*********");
		 	printf("\n\n\n\t\t\t\tPress any key to continue...");
		 	getch();
		 	break;
		 }
		 else
		 {
		 	printf("\n*********FAILES TO LODGIN*********");
		 	j++;
		 	getch();
		 	system("cls");
		 	
		 }
		 }while(j<=1);
		 if(j>1)
		 {
		 	printf("\nSORRY!YOU ENTERED WRONG LOGIN DETAILS FOR TWO TIMES");
		 	 getch();
		 	 exit(0);
		 }
		 system("cls");
	}

 void add_vehicles_record()
 {
 	first=NULL;
 	FILE *f;
 	int numbr,i,classe;
 	vehicles *temp;
 	vehicles *cur;
 	temp=(vehicles*)malloc(sizeof(vehicles));
 	printf("\n Enter the no of vehicles standing in the Lane: \n");
 	scanf("%d",&numbr);
 	for(i=1;i<=numbr;i++)
 	{
	system("cls");
	printf("\nenter the vehicle_data of vehicle %d",i);
	printf("\nenter vehicle number ");
	scanf("%s",temp->vehicle_no);
    for(classe=1;classe<=9;classe++)
	{
	printf("\nenter the vehicle class");	
	printf("\n1.(CAR/JEEP/VAN)\n2.BUS\n3.TRUCK\n4.UPTO 3 AXLE VEHICLE\n5.LCV\n6.4 to 6 AXLE\n7.HCME/EME\n8.7 OR MORE AXLE\n9.PROCEED");
	scanf("%d",&classe);
	if(classe==1)
	{
		strcpy(temp->vehicle_class,"CAR/JEEP/VAN");
		temp->fare_amount=50;
	}
	else if(classe==2)
	{
	   strcpy(temp->vehicle_class,"BUS");
	   temp->fare_amount=150;	
	}
	else if(classe==3)
	{
		strcpy(temp->vehicle_class,"TRUCK");
		temp->fare_amount=175;
	}
	else if(classe==4)
	{
		strcpy(temp->vehicle_class,"UPTO 3 AXLE VEHICLE");
		temp->fare_amount=190;
	}
	else if(classe==5)
	{
		strcpy(temp->vehicle_class,"LCV");
		temp->fare_amount=85;
	}
	else if(classe==6)
	{
		strcpy(temp->vehicle_class,"4 to 6 AXLE");
		temp->fare_amount=275;
	}
	else if(classe==7)
	{
		strcpy(temp->vehicle_class,"HCME/EME");
		temp->fare_amount=275;
	}
	else if(classe==8)
	{
		strcpy(temp->vehicle_class,"7 OR MORE AXLE");
		temp->fare_amount=375;
	}
	else 
	{
    printf("\nenter the lane no[1 to 4]");
	scanf("%d",&temp->Lane_no);	
	printf("\nenter the section");
	scanf("%s",&temp->section);
		system("cls");	
	printf("\n\nsucessfully added ");
	printf("\n\nTHE TOLL BILL ");
	printf("\nWELCOME TO HOSAKOTE TOLL PLAZA ");
	printf("\nVEHICLE NO: %s ",temp->vehicle_no);
	printf("\nVEHICLE CLASS: %s ",temp->vehicle_class);
	printf("\nFARE AMOUNT: %d",temp->fare_amount);
	printf("\nLANE NO: %d ",temp->Lane_no);
	printf("\nSECTION: %s",temp->section);
	printf("\n\npress any key for adding next vehicles");
	
	if(first==NULL){
		first=temp;
		temp->next=NULL;
	} else{
		cur=first;
		while(cur->next!=NULL){
			cur=cur->next;
		}
		cur->next=temp;
		temp->next=NULL;
	}
	if(i!=numbr){
		getch();
	}
	cur=first;
	f=fopen("TOLL_RECORD.txt","a+");
	while(cur!=NULL){	
	fprintf(f,"\n LANE NO:%d",cur->Lane_no);
	fprintf(f,"\n SECTION:%s",cur->section);
	fprintf(f,"\n VEHICLE NO:%s",cur->vehicle_no);
	fprintf(f,"\n VEHICLE CLASS:%s",cur->vehicle_class);
	fprintf(f,"\n FARE AMOUNT:%d",cur->fare_amount);
	fprintf(f,"\n-------------------------------");
	cur=cur->next;
}}
}}
	fclose(f); 
 
getch();
}

void view()
{
	system("cls");
	FILE *f1;
	char k;
	 f1=fopen("TOLL_RECORD.txt","r");
	while(1)
	{
		k=getc(f1);
		if(k==EOF)
		{
			break;
		}
		else
		{ 
		printf("%c",k);
	    }
		}
		getch();
	}


void main()
{
	int choice;
	printf("\n***********WELCOME TO HOSAKOTE TOLL PLAZA**********\n");
	login();
	{
	while(100)
	{
	system("cls");
	printf("\n1.Add_vehicles_record");
	printf("\n2.View details");
	printf("\n3.Exit");
	printf("\n\nEnter your choice\n");
	scanf("%d",&choice);
    switch(choice)
    {
    	 case 1:
    	   add_vehicles_record();
    	 break;
		 case 2:
		   view();
		 break;
		 case 3:
		   exit(0);
		 break;
		   	
}
}
}
}