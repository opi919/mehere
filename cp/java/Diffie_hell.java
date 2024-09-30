class Diffie_hell{
    public static int power(int m,int n,int p){
        // for handling big integer  m^n %p 

        if(n==0) return 1;
        
        int ans = power(m,n/2,p);
        ans = (ans*ans)%p;
        
        if(n%2==1) // if n is odd number 
          ans = (ans*m)%p;
        return ans;

    }
    public static void main(String[] args) {
        int primitive_root = 3,prime = 353;
        int xa,xb,ya,yb;
        xa = 97;
        xb = 233;
        ya = power(primitive_root,xa,prime);
        yb = power(primitive_root,xb,prime);

        int key1 = power(ya,xb,prime);
        int key2 = power(yb,xa,prime);
        System.out.println(key1+" "+key2);
    }
}
//  prime q=353, primitive root α =3, A’s secret key XA=97 and B’s secret XB=233.
