public class Demo2 {

   static int[][] sale_demo = {
      {2,2,2,1}, // Product#0 volume:2, weight:2, value:2, quantity:3
      {1,1,1,1}, // Product#1 volume:1, weight:3, value:4, quantity:5
      {3,3,5,1}  // Product#3 volume:4, weight:7, value:8, quantity:3
   };
   
   static Order[] getSaleOrder () {
      final int[][] demo = sale_demo;
      final Order[] sale = new Order[demo.length];
      for (int i=0; i<sale.length; ++i) {
         sale[i] = new Order(new Product(demo[i][0], demo[i][1], demo[i][2]), demo[i][3]);
      }
      return sale;
   }
   
   public static void main(String[] args) {
      final Order[] sale = getSaleOrder();
      
      System.out.println("The sale order:");
      int i=0;
      for (Order x : sale) {
         System.out.println("product#"+(i++)+" "+x);
      }
      
      Packaging packing = new MaximalPackaging(sale);
      
      final int [] caps  = new int[] {3};
      final int [] loads = new int[] {3};
      for (final int volume: caps ) 
         for (final int weight : loads) {
         System.out.printf("Trips for truck with max volume: %d, max load: %d%n",
               volume,weight);
         i=0;
         for (final Packaging.Trip trip : packing.getTrips(volume, weight)) 
            System.out.println("trip#"+(i++)+" "+trip);
      }
   }
}
