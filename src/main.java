import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import static java.lang.Character.isLetter;

public  class FinalProj {


    public static class HashEntry{
        String origpass;
        int key;
        String val;

        public HashEntry(String origpass) {
            this.origpass = origpass;




        }
        public String getVal() {
            return val;
        }
        public int getKey(){
            return key;
        }
        public void calcKey( int initialcap) {
            String fullString = "";
            for (int c = 0; c < origpass.length(); c++) {
                if (isLetter(origpass.charAt(c))) {

                    int temp = (int) origpass.charAt(c);
                    fullString += temp;

                } else {
                    fullString += origpass.charAt(c);

                }
            }

            System.out.println("Full String:" + fullString);

            //Initialize Empty Variables
            String newTemp = "";
            int sum = 0;

            //Parse through string
            for (int i = 0; i < fullString.length() / 3; i++) {

                for (int j = 3 * i; j < 3 * i + 3; j++) {

                    //Split string into pieces
                    newTemp += fullString.charAt(j);
                }

                //Print out substrings
//                System.out.println("Substring: " + newTemp);

                //Get sum
                sum += (Integer.parseInt(newTemp));


//
                newTemp = "";
                key = sum % initialcap;
                val = Integer.toString(sum);

            }
        }
        public  void doubleHash(Map<Integer, String> hashtable){
            boolean x = true;
            int num = Integer.parseInt(val);
            while(x){
                int newSum = 1 + (num % 7);
                if((double)(hashtable.size() + 1) /(double)getInitialcap()> 0.75){
                    setInitialcap(initialcap *2);
                }
                key = (num + newSum) % getInitialcap();
                if(!(hashtable.containsKey(key))){

                    hashtable.put(key, val);
                    x = false;
                }
                else{
                    x = true;
                    num = num * 3;
                }

            }


        }



    }
    static int initialcap;

    public static void setInitialcap(int initialcap) {
        FinalProj.initialcap = initialcap;
    }

    public static int getInitialcap() {
        return initialcap;
    }
    //        static Map<Integer, String> hashtable = new HashMap<>();





    public static void main(String arg[]) {
        // Get password from user
        Scanner in = new Scanner(System.in);


        //Get what kind of hashing user wants
        System.out.println("How big would you like the hash map");
        setInitialcap(in.nextInt());
        Map<Integer, String> hashtable = new HashMap<>(getInitialcap());
        System.out.println(hashtable.size());




        while (true) {


            System.out.println("Enter your password");
            String password = in.next();
            HashEntry entry = new HashEntry(password);
            entry.calcKey( getInitialcap());
            if(hashtable.containsKey(entry.getKey())){
                 entry.doubleHash(hashtable);


            }
            else{
                if(((double)hashtable.size() + 1) / (double)getInitialcap() > 0.75){
                    setInitialcap(getInitialcap() * 2);
                }

                hashtable.put(entry.getKey(), entry.getVal());
            }

            System.out.println(hashtable);
//            System.out.println(initialCap);


        }


    }


}
