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
public class SampleProject {
    static String text="Hello World!";

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println(text);
        Integral x=new Integral(5, 6);
        System.out.println(x.getValue());
        Integral y=new Integral();
        int []arr= new int[5];
        int i=5;
        while (i>0){
            i-=1;
            arr[i]=(i+1)*(i+1);
        }
        
        y.updateValue(100);
        Integral z= new Integral(arr);
        Integral a= new Integral(89);
        
        Integral []arr1= new Integral[3];
        arr1[0]=a;
        arr1[1]=y;
        arr1[2]=z;
        System.out.println(Integral.add(arr1));
        System.out.println(Integral.multiply(arr1));
        a.showValue();
        y.showValue();
        z.showValue();
        
    
    }
    
}
