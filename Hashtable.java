public class Hashtable {
   private Node a[] = new Node[10];
   private Node head;
   private int size;
   private Node tmp;
   
         
    public static void main(String[] args){
     Hashtable table = new Hashtable();
     table.insert(1);
     table.insert(5);
     table.insert(28);
     table.delete(5);
     table.insert(15);
     table.insert(8);
     table.dumphash();
     table.delete(1);
     table.insert(18);
     table.insert(25);
     table.delete(33);
     table.dumphash();
    }
   
    
   public Hashtable()
   {
      
      head=null;
      tmp=null;
      size=0;
    }
    
    public int hash(int val){
      
      return(val%10);
    
    }
    
  
    public void insert(int val){
    
      head = a[hash(val)];
      tmp = new Node();
      tmp.value = val;
      tmp.next = head;
      a[hash(val)] = tmp;
     
      System.out.println("Inserted: " + val);
     
       }
     
    public void delete(int val){
      int check = 0;
      head = a[hash(val)];
      tmp = a[hash(val)];
      if(head != null){
         if(head.value == val){
            a[hash(val)] = head.next;
            check++;
         }else{
            while(head != null){
                tmp = head;
                head = head.next;
                if(head.value == val){
                  check++;
                  if(head.next == null){
                     tmp.next = null;
                     head = null;
                  }else{
                     tmp.next = head.next;
                      head = null;
                  }
               }
            }
         }
       }
       if(check == 0){
         System.out.println("Value Not Found");
       }else{
            System.out.println("Deleted: " + val);
      }
   }

    public void dumphash(){
      int i = 0;
      while( i < 10){
         System.out.print("a[" + i + "]: ");
            head = a[i];
            if(head != null){
            while(head.next != null){
               System.out.print(head.value + " ");
               head = head.next;
               
            }
           System.out.print(head.value + " ");

           }
         i++;
         System.out.println();
      }
      }
   }
   
   
     