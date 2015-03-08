 public static PNode<Integer> copyPostingsList(PNode<Integer> L) {
     if (L == null)
	 return null;

     // create a new list with next field assigned
     while (L.next != null) {
	 PNode<Integer> temp = new PNode<>(L.data, null, null);
     }
     
 }
