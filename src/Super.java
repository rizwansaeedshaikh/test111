
public class Super
{
    int index = 5;

    public void printVal()
    {
        System.out.println(index);
    };

    public static void main(String[] args)
    {
        Super sup = new Sub();
        sup.printVal();
    }
}

class Sub extends Super
{
    int index = 2;

    public void printVal()
    {
        System.out.println(this.index);
    };

}
