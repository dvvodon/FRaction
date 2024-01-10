
/**
 * This class represents a value as a fraction.
 *
 * @author (Daveed Vodonenko)
 * @version (a version number or a date)
 */
public class Fraction
{
    //Instance Var
    private int numerator, denomenator;
    private final double EPSILON = Math.abs(Math.PI - (355.0/113.0));
    //Constructors
    /**
     * Default constuctor. Creates new fraction object 1/1
     */
    
    Fraction(){
        numerator = 1;
        denomenator = 1;
    }
    
    /**
     * returns set Fraction n/d
     * @param n the numerator 
     * @param d the denomenator
     */
    Fraction(int n, int d){
        numerator = n;
        denomenator = d;
        checkD();
    }
    
    /**
     * Parses String and returns fraction value held within string
     * @param n string containg fraction 
     */
    Fraction(String n){
        int loc = n.indexOf("/");
        if(loc > 0){ 
        numerator = Integer.parseInt(n.substring(0,loc));
        denomenator = Integer.parseInt(n.substring(loc + 1));
        checkD();
    } else{
        System.out.println("Invalid fraction Format");
        numerator = 1;
        denomenator = 1;
    }
    }
    
    /**
     * copies fraction object to a new object
     */
    Fraction(Fraction myFraction){
        numerator = myFraction.numerator;
        denomenator = myFraction.denomenator;
    }
    
    //Behavior Methods
    private void checkD(){
        int d = denomenator;
        if(d == 0){
            System.out.println("Invalid fraction format");
            denomenator = 1;
        }
       
    }
    
    //Accessors
    public int getNumerator(){
        return numerator;
    }
    
    public int getDenomenator(){
        return denomenator;
    }
    
    public String toString(){
        return numerator + "/" + denomenator;
    }
    
    public double toDouble(){
        return (double) numerator / denomenator;
    }
    
    public Fraction Milu(Fraction a){
        double num= a.getNumerator();
        double den= a.getDenomenator();
        while( Math.abs(Math.PI - (num/den)) > EPSILON){
            if((num/den) > Math.PI){
             den++;   
            }
            else{
             num++;
            }
        }
        int num1 = (int)(num);
        int den1 = (int)(den);
        Fraction finalFrac = new Fraction(num1,den1);
        return finalFrac;
    }
    //mutator methods
    public void reduce(){
        int a = numerator;
        int b = denomenator;
        numerator = (numerator/ gdc(a,b));
        denomenator = (denomenator/ gdc(a,b));
    }
    
    public void setNum(int a){
        numerator = a;
    }
    
    public void setDen(int a){
        denomenator = a;
    }
    //helper
    private int gdc(int a, int b){
        if (b == 0) {
      return a;
    } else {
      return (gdc(b, a % b));
    }
    }
    
    
    //static 
    public static Fraction multiply(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int denA = a.getDenomenator();
        int numB = b.getNumerator();
        int denB = b.getDenomenator();
        int num = numA*numB;
        int den = denA*denB;
        Fraction finalFrac = new Fraction(num,den);
        finalFrac.reduce();
        return finalFrac;
    }
    
    public static Fraction add(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int numB = b.getNumerator();
        int denA = a.getDenomenator();
        int denB = b.getDenomenator();
        numA = numA*denB;
        numB = numB*denA;
        int den = denA * denB;
        int num = numA + numB;
        Fraction finalFrac = new Fraction(num,den);
        System.out.println(finalFrac.toString());
        finalFrac.reduce();
        return finalFrac;
    }
    
    public static Fraction subtract(Fraction a, Fraction b){
        int numA = a.getNumerator();
        int numB = b.getNumerator();
        int denA = a.getDenomenator();
        int denB = b.getDenomenator();
        numA = numA*denB;
        numB = numB*denA;
        int den = denA * denB;
        int num = numA - numB;
        Fraction finalFrac = new Fraction(num,den);
        finalFrac.reduce();
        return finalFrac;
    }
    
    public static Fraction divide(Fraction a, Fraction b){
        int num = a.getNumerator() * b.getDenomenator();
        int den = a.getDenomenator() * b.getNumerator();
        Fraction finalFrac = new Fraction(num,den);
        finalFrac.reduce();
        return finalFrac;
    }
    
    
}
