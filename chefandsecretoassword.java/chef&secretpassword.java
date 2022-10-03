/* package codechef; // don't place package name! */

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
	    Scanner scn = new Scanner(System.in);
        int numOfTest = scn.nextInt();
        for(int i = 0; i < numOfTest; i++){
            int len = scn.nextInt();
            String s = scn.next();
            String ans =getPassWord(len, s);
            System.out.println(ans);
        }
	}

    public static String getPassWord(int len, String s){
        int [] z = getZArray(s);
        HashMap<Integer, Integer> Hmap = new HashMap<>();
        for(int val: z){
            if(val==0){
                continue;
            }
            else{
                for(int i=1; i<=val; i++){
                    Hmap.put(i,Hmap.getOrDefault(i,0)+1);
                }
            }
        }
        int ans = 0;
        int freq =0;
        for(int key: Hmap.keySet()){
            if(Hmap.get(key)>freq){
                ans=key;
                freq = Hmap.get(key);
            }
            else if(Hmap.get(key)==freq){
                if(ans<key){
                    ans = key;
                }
            }
        }

        if(ans==0){
            return s;
        }
        else{
            return s.substring(0,ans);
        }
    }


    public static int [] getZArray(String s){
        
        int [] z = new int[s.length()];
        z[0]=0;
        int r=0;
        int l=0;

        for(int i=1; i<s.length(); i++){
            
            if(i>r){
                r=l=i;
                while(r<s.length() && s.charAt(r)==s.charAt(r-l)){
                    r++;
                }
                z[i]=r-l;
                r--;
            }
            else{

               int k = i-l;
                if(z[k]<=r-i){
                    z[i]=z[k];
                } 
                else{
                    l=i;
                    while(r<s.length() && s.charAt(r)==s.charAt(r-l)){
                        r++;
                    }
                    z[i]=r-l;
                    r--;
                }

            }
        }
        return z;
    }
}
