//In this lab you are to implement a sorted list with the doubly linked technique. You are required
//to use the following DLNode class.

public class SortedList {
   private DLNode Head, Tail;

   public void insert(double n){
       
	   DLNode crn = Head;
	   DLNode prv = null;
	   //crn.data = n;
	    while (crn != null && crn.data <= n){
			prv = crn;
			crn = crn.Next;
		}
		
		DLNode tmpt = new DLNode();
		tmpt.data = n;
		
		if (crn == null){
			prv = Tail;
		}else{
			prv = crn.Prev;	
		}
		
		if(prv != null){
			prv.Next = tmpt;
		}else{
			Head = tmpt;
		}
		
		tmpt.Prev = prv;
		tmpt.Next = crn;
		
		if (crn != null){
			crn.Prev = tmpt;
		}else{
			Tail = tmpt;
		}
		

   
   }

   public void listAscending() {
      DLNode tmpt = this.Head;
	  int count = 0;
	  
      while(tmpt != null){
         System.out.printf("%f ",tmpt.data);
         count++;
		  if (count == 5){
			  System.out.println();
			  count = 0;
		  }
		  tmpt = tmpt.Next;
      }
   
   }

   public void listDescending() {
      
      DLNode tmpt = this.Tail;
	  int count = 0;
	  
      while(tmpt != null){
         System.out.printf("%f ",tmpt.data);
         count++;
		  if (count == 5){
			  System.out.println();
			  count = 0;
		  }
		  tmpt = tmpt.Prev;
      }
   
   }

}
