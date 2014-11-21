public class SwapValues
{
   public static void falseSwap(MyInt a, MyInt b)
   {
      MyInt temp = new MyInt(a.get());
      a.set(b.get());
      b.set(temp.get());
   }
   
   public static void main(String[] args)
   {
      MyInt x = new MyInt(3);
      MyInt y = new MyInt(4);
      falseSwap(x, y);
      System.out.println(x.get() + " " + y.get());
   }
}