
public class EnumTest
{

    enum CoffeeSize
    {
        BIG(8), HUGE(10), OVERWHELMING(12){
            
            String getCoffeeSizeComment(){
                return "Overwhelming comment";
            }
        };

        String getCoffeeSizeComment(){
            return "Default comment";
        }
        
        int size;

        CoffeeSize(int size)
        {
            this.size = size;
        }

        public int getSize()
        {
            return size;
        }

        public void setSize(int size)
        {
            this.size = size;
        }

    }

    CoffeeSize coffeeSize;

    public CoffeeSize getCoffeeSize()
    {
        return coffeeSize;
    }

    public void setCoffeeSize(CoffeeSize coffeeSize)
    {
        this.coffeeSize = coffeeSize;
    }

    public static void main(String[] args)
    {
        EnumTest test1 = new EnumTest();
        test1.coffeeSize = CoffeeSize.BIG;
        System.out.println(test1.getCoffeeSize().getSize());
        System.out.println(test1.coffeeSize.getCoffeeSizeComment());
        
        EnumTest test2 = new EnumTest();
        test2.coffeeSize = CoffeeSize.OVERWHELMING;
        System.out.println(test2.coffeeSize.getCoffeeSizeComment());
        
        System.out.println(CoffeeSize.valueOf("BIG")); //BIG
        System.out.println(CoffeeSize.valueOf("BIG").getClass()); //class EnumTest$CoffeeSize
        
        System.out.println(CoffeeSize.values());
        
        CoffeeSize[] css = CoffeeSize.values();
        for(CoffeeSize cs : css) {
            System.out.println(cs);
        } //BIG HUGE OVERWHELMING
        
        for(CoffeeSize cs : css) {
            System.out.println(cs.size);
        }//8 10 12 
        
        for(CoffeeSize cs : css) {
            System.out.println(cs.getDeclaringClass());
        }//class EnumTest$CoffeeSize
        
        for(CoffeeSize cs : css) {
            System.out.println(cs.ordinal()); //ordinal is position in enum declaration, starting from 0.
        } // 0 1 2
    }
}
