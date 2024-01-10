import java.util.Scanner;
 

public class QuizGame
{
  private Fraction a = new Fraction();
  private Fraction b = new Fraction();
  private int multiply, divide, add, subtract, operation;
  QuizGame(){
      int num1 = (int)(Math.random()*9 + 1);
      int den1 = (int)(Math.random()*9 + 1);
      int num2 = (int)(Math.random()*9 + 1);
      int den2 = (int)(Math.random()*9 + 1);
      a.setNum(num1);
      a.setDen(den1);
      b.setNum(num2);
      b.setDen(den2);
    multiply = 0;
    divide = 1;
    add = 2;
    subtract = 3;
    
  }
    
  public void run(){
      int operation = (int)(Math.random()*4);
      Scanner in = new Scanner(System.in);
      this.operation = operation;
      System.out.println(getA() + " " + operate(operation) + " " + getB() + " =");
      System.out.println("Input Numerator");
      String resp = in.nextLine();
      if(resp.equals("quit")) System.exit(0);
      int num = Integer.parseInt(resp);
      System.out.println("input Denomenator");
       String resp0 = in.nextLine();
      if(resp0.equals("quit")) System.exit(0);
      int den = Integer.parseInt(resp0);
      Fraction response = new Fraction(num,den);
      if(equals(response)){
          System.out.println("Correct");
          QuizGame newGame = new QuizGame();
          newGame.run();
      } else if(!equals(response)){
          System.out.println("incorrect");
          QuizGame newGame = new QuizGame();
          newGame.run();
      }
      
  }
  
  public boolean equals(Fraction f){
      if(operation == multiply){
         Fraction ok = Fraction.multiply(a,b);
         System.out.println(ok.toString());
         if(ok.getNumerator() == (f.getNumerator()) && ok.getDenomenator() == (f.getDenomenator())) return true;
      } else if(operation == divide){
         Fraction ok = Fraction.divide(a,b);
         System.out.println(ok.toString());
         if(ok.getNumerator() == f.getNumerator() && ok.getDenomenator() == f.getDenomenator()) return true;
      } else if(operation == add){
         Fraction ok = Fraction.add(a,b);
         System.out.println(ok.toString());
         if(Math.abs(ok.getNumerator()) == Math.abs(f.getNumerator()) && Math.abs(ok.getDenomenator()) == Math.abs(f.getDenomenator())) return true;
      } else if(operation == subtract){
         Fraction ok = Fraction.subtract(a,b);
         System.out.println(ok.toString());
         if(ok.getNumerator() == f.getNumerator() && ok.getDenomenator() == f.getDenomenator()) return true;
      }else{
          System.out.println(this.operation);
          return false;
      }
      return false;
  }
    public char operate(int operation){
        if(operation == multiply) return '*';
        else if(operation == divide) return '/';
        else if(operation == add) return '+';
        else if(operation == subtract) return '-';
        return 'O';
    }
  public String getA(){
      return a.toString();
  }
  
  public String getB(){
      return b.toString();
  }
}
