/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample.project;

/**
 *
 * @author piyush
 */
public class Integral {
    private int value;
    
    Integral(){
        this.value=0;
    }
    
    Integral(int val){
        this.value=val;
    }
    
    Integral(int val_1, int val_2){
        this.value=val_1+val_2;
    }
    
    Integral(int [] vals){
        int ctr=0;
        int res=0;
        int len=vals.length;
        
        for (int i=0; i<len; i++){
            res+=vals[i];
        }
        
        this.value=res;
    }
    
    public int getValue(){
        return this.value;
    }
    
    public void updateValue(int val){
        this.value=val;
    }
    
    public void showValue(){
        System.out.println(this.value);
    }
    
    public static int add(Integral val_1, Integral val_2){
        return val_1.getValue()+val_2.getValue();
    }
    
    public static int add(Integral []arr){
        int len=arr.length;
        int res=0;
        for(int i=0; i<len; i++){
            res+=arr[i].getValue();
            
        }
        return res;        
    }
    
    public static int multiply(Integral val_1, Integral val_2){
        return val_1.getValue()*val_2.getValue();
    }
    
    public static int multiply(Integral []arr){
        int len=arr.length;
        int res=1;
        for(int i=0; i<len; i++){
            res*=arr[i].getValue();
            
        }
        return res;        
    }
    
    public static int subtract(Integral val_1, Integral val_2){
        return val_1.getValue()-val_2.getValue();
    }
}
