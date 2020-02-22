package com.capgemini.pecunialogin;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner; 
public class LoginPage {
public static void main(String[] args) {
Map<Integer,String> hm=new HashMap<Integer,String>();
Scanner sc=new Scanner(System.in);
/*System.out.println("enter user");
 int a=sc.nextInt();
 System.out.println("enter pass");
 String b=sc.next();
 hm.put(a,b);*/
hm.put(10101,"shanthi");
hm.put(10201,"vidya");
hm.put(10301,"nikshitha");
hm.put(10401,"pritam");
//System.out.println(hm);
System.out.println( "enter user name:");

int user=sc.nextInt();
if(hm.containsKey(user)) {
System.out.println("Enter password");
String pass=sc.next();
if(hm.get(user).equals(pass)) {
System.out.println("welcome");
}
else {
System.out.println("invalid ");
}
}
else {
System.out.println("invalid name");
}
}

}