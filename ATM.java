package com.atm;

import java.util.Scanner;

public class ATM {
	
	private static int balance = 0;
	
	public static void deposit(int arr[] ,int notes[]) {
		int counter=1;
		int i=1;
		while(counter==1) {
			balance = 0;
			Scanner sc = new Scanner(System.in);
			System.out.print("Deposit "+i+": ");
			for(int j=0; j<arr.length; j++) {
				System.out.print(arr[j]+"s: ");
				int num = sc.nextInt();
				notes[j]=notes[j]+num;
				if(notes[j]<0) {
					System.out.println("Incorrect deposit amount");
				}
				else
					balance = balance + arr[j]*notes[j];
			}
			System.out.println("-----------------------------------------------\n");
			boolean allNotesZero = true;
			for(int j=0; j<arr.length; j++){
				if(notes[j]!=0) {
					allNotesZero = false;
				}
			}
			if(allNotesZero==true) {
				System.out.println("Deposit amount cannot be zero ");
			}
			else {
				System.out.print("Balance: ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr[j]+"s="+notes[j]+" ");
				}
				System.out.println("Total= "+ balance);
				i++;
				
			}
			System.out.println("To exit enter 0 or to continue enter 1");
			counter = sc.nextInt();
			if(counter==0) {
				break;
			}
		}
	}
	
	public static void withdraw(int arr[], int notes[]) {
		int counter = 1;
		int i=1;
		int with;
		while(counter==1) {
			Scanner sc = new Scanner(System.in);
			System.out.print("Withdraw "+i+": ");
			with = sc.nextInt();
			System.out.println("-----------------------------------------------\n");
			if(with<=0 || with>balance) {
				System.out.println("Incorrect or insufficient funds");
			}
			else {
				int tempbal = balance-with;
				System.out.print("Dispensed: ");
				int avail;
				for(int j=0; j<arr.length && with!=0; j++) {
					avail = 0;
					avail = with/arr[j];
					if(avail<=notes[j] && notes[j]!=0) {
						System.out.print(arr[j]+"s="+avail +"  ");
						with = with%arr[j];
						notes[j] = notes[j]-avail;
						balance = balance-(arr[j]*avail);
					}
					else {
						while(avail!=0) {
							avail--;
							if(avail<=notes[j] && notes[j]!=0) {
								System.out.print(arr[j]+"s="+avail +"  ");
								with = with%arr[j];
								notes[j] = notes[j]-avail;
								balance = balance-(arr[j]*avail);
							}
						}
					}
				}
				System.out.println(" ");
				System.out.print("Balance: ");
				for(int j=0; j<arr.length; j++) {
					System.out.print(arr[j] + "s=" + notes[j]+ " ");
				}
				System.out.println("Total: "+balance);
				i++;
				if(tempbal!=balance) {
					System.out.println("Required notes not available for withdrawal");
				}
			}
			System.out.println("To exit enter 0 or to continue enter 1");
			counter = sc.nextInt();
			if(counter==0) {
				break;
			}
		}
	}

	public static void main(String[] args) {
		int arr[] = {2000,1000,500,200,100,50};
		int notes[] = {0,0,0,0,0,0};
		deposit(arr,notes);
		withdraw(arr,notes);
	}
}