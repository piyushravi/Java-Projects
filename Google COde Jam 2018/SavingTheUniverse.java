import java.util.*;
class Solution
{
    public static long calcStren(String str)
    {
        int l = str.length();
        int p=1;
        long s=0;
        for(int i=0;i<l;i++)
        {
            if(str.charAt(i)=='C')
            {
                p *= 2;

            }
            else
            {
                s += p;
            }
        }
        return s;
    }
    public static void main(String args[])
    {
        Scanner ob=new Scanner(System.in);
        int T = ob.nextInt();
        if(true)
        {
            String[] R= new String[T];
            int c;
            long D;
            String P;
            int l;
            ob.nextLine();
            for(int i=1;i<=T;i++)
            {
                c=0;
                String DP=ob.nextLine();
                D=Long.parseLong(DP.substring(0,DP.indexOf(' ')));
                P=DP.substring(DP.indexOf(' ')+1);
                l = P.length();
                long S = calcStren(P);
                for(int k=0;k<l;k++)
                {
                    if(S>D)
                    {
                    int j = l-1;
                    while (j>=0)
                    {
                        if (S<=D){
                          break;

                        }

                        if(j>=1)
                        {
                            if(P.charAt(j)=='S' && P.charAt(j-1)=='C')
                            {
                                P=P.substring(0,j-1)+"SC"+P.substring(j+1,l);
                                S=calcStren(P);
                                c++;
                                j = l-1;
                            }
                            else{
                              j--;
                            }
                        }
                        // This was dead code in the original version as this condition will never be true
                        // because if there is S at 1 and C at 0 then you swap them and there is C at 1 and S at 0. 
                        // else if(P.charAt(j)=='C' && P.charAt(j+1)=='S')
                        // {
                        //     P="SC"+P.substring(j+2);
                        //     S=calcStren(P);
                        //     c++;
                        //
                        // }
                        else{
                          j--;
                        }

                    }
                    }
                    if (S<=D)
                        break;
                }
                if(S>D)
                {
                    R[i-1]="IMPOSSIBLE";
                }
                else
                {
                  R[i-1]=Integer.toString(c);
                }

            }
            for(int i=0;i<T;i++)
            {
                System.out.println("CASE #"+(i+1)+": "+R[i]);
            }
        }
    }
}
