package models;

import java.io.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Scanner;

/**
 * Created by faima on 1/24/17.
 */
public class Utility{
   

    public static int integerScanner(){
        int number = 0;
        String string = new Scanner(System.in).nextLine();
       try {
           number = Integer.parseInt(string);
       }catch (NumberFormatException e){
           System.out.print("Please enter numeric only. Try again: ");
           integerScanner();
       }
       return number;
    }
    public void registerPatient(String text, String filename) throws IOException {
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(filename, true))) {
            char[] chars = text.toCharArray();
            for (int i = 0; i < chars.length; i++) {
                char c = chars[i];
                bufferedWriter.write(c);
            }


        } catch (IOException e) {

        }
    }

    public  String displayDetails(String filename) throws FileNotFoundException {

        String output="";

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(filename))) {
        int i;
        while ((i = bufferedReader.read())!=-1){
            output+=(char) i;
        }


    }catch (IOException e){

    }
    return output;
   }
   public String removePatient(String filename){
       String output="";


       try{

       File file = new File(filename);

           if(file.delete()){
               System.out.println(file.getName() + " is deleted!");

           }else{
               System.out.println("Delete operation is failed.");
           }

       }catch(Exception e){

           e.printStackTrace();

       }
       return output;
   }
   public static void printLn(Object out){
       System.out.println(out);
   }
    public static   String hashPassword(String password) throws NoSuchAlgorithmException {

            MessageDigest md5 = MessageDigest.getInstance("MD5");
            md5.update(password.getBytes());
            byte [] b=md5.digest();
            StringBuffer sb = new StringBuffer();
            for (byte b1:b) {
                sb.append(Integer.toHexString(b1& 0xff).toString());


            }


        return sb.toString();
    }
    public static void main(String []args){
        try {
            System.out.println(hashPassword("faima"));
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }

}
