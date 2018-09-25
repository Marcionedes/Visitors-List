package visitorsList;

public class List {
    Immigrant first;
    Immigrant last;
    Integer quantity = 0;
    Integer id;

    public void addBeggin(Immigrant guest) {
        if(first==null){
            first = guest;
            last = guest;
        } else {
            Immigrant aux = first;
            first = guest;
            first.next = aux;
        }
        quantity++;
    }
    public void addEnd(Immigrant guest) {
        if(first == null){
            first = guest;
            last = guest;
        } else {

            Immigrant aux = last;
            last = guest;
            last.before = aux;
            aux.next = last;
        }
        quantity++;
    }
    //Used to add an Element(person) at any position in the queue.
    public void addAt(Immigrant guest,Integer position) {
        if(first==null) { // checking weather there is an element in the list
            first = guest;
            last = guest;
        } else {
            if(position >= quantity) {
                Immigrant aux = last;
                last = guest;
                last.before = aux;
                aux.next = last;
            } else {
                Immigrant aux = first;
                Immigrant auxBefore = null;
                Immigrant auxNext=null;
                
                if(position<=1){
                    addBeggin(guest);
                    quantity += 1;
                } else {
                    if(position>=quantity){
                        addEnd(guest);
                    } else {
                        for(int i=1; i < position;i++){
                            aux = aux.next;
                            if(i == position-1){
                                auxBefore = aux.before;
                                auxNext = aux;
                                aux = guest;
                                aux.before = auxBefore;
                                aux.next = auxNext;
                                auxBefore.next = aux;
                                auxNext.before = aux;
                                quantity+=1;
                            }
                        }
                    }
                }
            }
        }
        quantity++;
    }
    public void deleteMany(Integer quantity) {
        if(quantity >= this.quantity) {
            first = null;
            last = null;
            this.quantity = 0;
        } else {
            Immigrant aux = last;
            for(int i=0; i < quantity;i++) {
                aux = aux.before;
                if(i == quantity-1){
                    aux.next = null;
                    last = aux;
                    this.quantity -= quantity;
                }
            }
        }
    }
    public void deleteAtPosiiton(int position) {
        if(position > quantity) {
            System.out.println("Couldn't find the position to delete");
        } else {
            Immigrant aux = first;
            Immigrant auxBefore = null;
            Immigrant auxAfter = null;
            if(position <= 1){ 
                auxAfter = aux.next;
                first = auxAfter;
                first.before = null;
                quantity -=1;
            } else {
                for(int i=1; i < position;i++) {
                    aux = aux.next;
                    if(i == position -1) {
                        auxBefore = aux.before;
                        auxAfter = aux.next;
                        auxBefore.next = auxAfter;
                        if (auxAfter != null) {
                            auxAfter.before = auxBefore;
                        } else {
                            last = auxBefore;
                        }
                    }
                }
            }
        }
    }
    public void deleteAtBegin() {
        deleteAtPosiiton(1);
        quantity = quantity-1;
    }
    public void deleteAtEnd() {
        deleteAtPosiiton(quantity);
        quantity = quantity-1;
    }
    public void showAll() {
            Immigrant aux = first;
            if(aux == null){
                System.out.println("There is nobody in the queue!");
            } else {
                while (aux != null) {
                    if (aux != null) {
                        System.out.println(
                        "\nID:"+aux.getId()
                         +"\nFirst name:"+aux.getFirstName()+ "\n"
                         +"Last name:"+aux.getLastName() +"\n"
                         +"Date of Arrival:"+aux.getDateOfArrival()+"\n"
                         +"Passaport Number:"+aux.getPassport()+"\n");             
                         aux = aux.next;
                    }
               }
               System.out.println("All records printed successfully!");
         }
    }
    public void searchId(int id) {
        Immigrant aux = first;
        if(first == null) {
            System.out.println("There is nobody in the queue!");
        } else {
             while(id != aux.id || aux.next != null) {
                 if(id==aux.id){
                 System.out.println(
                 "\nID:"+aux.getId()
                 +"\nFirst name:"+aux.getFirstName()+ "\n"
                 +"Last name:"+aux.getLastName() +"\n"
                 +"Date of Arrival:"+aux.getDateOfArrival()+"\n"
                 +"Passaport Number:"+aux.getPassport()+"\n");
                 break;
                 } else {
                 if(id == last.id){
                	 System.out.println(
                     "\nID:"+last.getId()
                     +"\nFirst name:"+last.getFirstName()+ "\n"
                     +"Last name:"+last.getLastName() +"\n"
                     +"Date of Arrival:"+last.getDateOfArrival()+"\n"
                     +"Passaport Number:"+last.getPassport()+"\n");
                     break;
                     } else {
                    	 aux = aux.next;
                         }
                   }
               }
           }
       }
   }//closing class




