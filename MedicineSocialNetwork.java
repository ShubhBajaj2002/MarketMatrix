import java.util.*;


public class MedicineSocialNetwork {
    
    private Scanner input;
	private HashMap<String,Manufacturer > manufacturerDetails;
   	private HashMap<String,Customer > customerDetails;
    private HashMap<String,Product > productDetails;   
    private HashMap<String,ShopsAndWarehouse > shopsAndWarehouseDetails;
    private HashMap<String,Integer> productAndQuantity;
    private HashMap<Integer, CustomerOrder> currentOrders;

    private int numberOfManufacturers;
	private int numberOfCustomers;
	private int numberOfProducts;
	private int numberOfShopsAndWarehouses;
	private int numberOfOrders;

//////////////////////////////////////////// CONSTRUCTORS ////////////////////////////////////////////

	public MedicineSocialNetwork(){
    	this.input = new Scanner(System.in);

    	this.manufacturerDetails = new HashMap<>();
    	this.customerDetails = new HashMap<>();
    	this.productDetails = new HashMap<>();
    	this.shopsAndWarehouseDetails = new HashMap<>();
    	this.currentOrders = new HashMap<>();

    	this.numberOfManufacturers = 0;
    	this.numberOfCustomers = 0;
    	this.numberOfProducts = 0;
    	this.numberOfShopsAndWarehouses = 0;
    	this.numberOfOrders = 0;

	}

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int option = 0;
        MedicineSocialNetwork medicinesocialnetwork = new MedicineSocialNetwork();
        while(option != 10){
        	System.out.print("\nSELECT AN OPTION FROM THE LIST BELOW:\n\n" + 
        		"1.Create.\n"+
        		"2.Delete.\n"+
        		"3.Print.\n"+
        		"4.Add a product to manufacturer. \n"+
        		"5.Add a certain number of copies of a product to a shop. \n"+
        		"6.Add an order of a product from a customer.\n"+
        		"7.List all the purchases made by a customer.\n"+
        		"8.List inventory of a shop.\n"+
        		"9.Products made by a manufacturer.\n"+
        		"10.Exit.\n\n");
        	
        	option = input.nextInt();
        	switch(option){
        		case 1:
        			medicinesocialnetwork.create();
        			break;
        		case 2:
        			medicinesocialnetwork.delete();
        			break;
        		case 3:
        			medicinesocialnetwork.print();
        			break;
        		case 4:
        			medicinesocialnetwork.addProductToManufacturer();
        			break;
        		case 5:
        			medicinesocialnetwork.addProductToShop();
        			break;
        		case 6:
        			medicinesocialnetwork.addAnOrder();
        			break;
        		case 7:
        			medicinesocialnetwork.listAllPurchasesMadeByCustomer();
        			break;
        		case 8:
        			medicinesocialnetwork.listInventoryOfShop();
        			break;
        		case 9:
        			medicinesocialnetwork.productsMadeByManufacturer();
        			break;
        		case 10:
        			System.out.println("Thankyou!\n");
        			break;
        		default:
				   System.out.println("Please enter a valid option number.");
			}
        }

    }


//////////////////////////////////////////// CLASSES ////////////////////////////////////////////

     public class Manufacturer{
	    String name;
	    HashSet <String> products;

	    public Manufacturer(String name){
	    	this.name = name;
	    	this.products = new HashSet<>();
	    }
	   
	}   

	public class Customer{
		int order_count = 0;
	    String name;
	    HashMap<String, Integer> purchases;

	   	public Customer(String name){
	    	this.name = name;
	    	this.purchases = new HashMap<>();
	    }
	}  

	public class Product{
	    String name;
	    String manufacturerName;

	 	public Product(String name,String manufacturerName){
	    	this.name = name;
	    	this.manufacturerName = manufacturerName;
	    }
	   
	}  

	public class ShopsAndWarehouse{
	    String name;
	    HashMap<String, Integer>  productAndQuantity ;
	    public ShopsAndWarehouse(String name){
	    	this.name = name;
	    	this.productAndQuantity = new HashMap<>();
	    }
	}  

	public class CustomerOrder{
		HashMap<String, Integer> productAndQuantity;
		String customer;
		public CustomerOrder(String customer, int order_count){
			this.customer = customer;
			this.productAndQuantity = new HashMap<>();

		}
	}
		
//////////////////////////////////////////// CREATE ////////////////////////////////////////////

    private void create(){
		System.out.print("Select The Entity Which You Want To Create:(options range:[1,4])\n"+
		"1.Manufacturer\n"+
		"2.Customer\n"+
		"3.Product\n"+
		"4.Shops And Warehouse\n\n");
		int type = 0;
		type = this.input.nextInt();
		switch(type){
			case 1:
				this.createManufacturer();
				break;
			case 2:
				this.createCustomer();
				break;
			case 3:
				this.createProduct();
				break;
			case 4:
				this.createShopsAndWarehouse();
				break;
			default:
			System.out.println("\nCouldn't create entity! Invalid option.\nShould be an integer in range [1, 4]");
			return;
		}
	}
	
	

	private void createManufacturer(){
		System.out.println("Enter the name of the Manufacturer:\n");
		this.input.nextLine();
		String name = this.input.nextLine();
		if(this.manufacturerDetails.containsKey(name)){
			System.out.println("Manufacturer "+ name +" already exists");
		}
		else createManufacturer(name);
		
	}
	private void createManufacturer(String name){
		Manufacturer m = new Manufacturer(name);
		this.manufacturerDetails.put(name,m);
		System.out.println("Created Manufacturer : " + m.name);

	}

	private void createCustomer(){
		System.out.println("Enter the name of the Customer:\n");
		this.input.nextLine();
		String name = this.input.nextLine();
		if(this.customerDetails.containsKey(name)){
			System.out.println("Customer " + name + " already exists.");
		}
	    else createCustomer(name);
		
	}
	private void createCustomer(String name){
		Customer c = new Customer(name);
		this.customerDetails.put(name,c);
		System.out.println("Created Customer : " + c.name);
	}
	private void createProduct(){
		System.out.println("Enter the name of the Product:\n");
		this.input.nextLine();
		String name = this.input.nextLine();
		Product p = new Product(name, null);
		this.productDetails.put(name,p);
		this.numberOfProducts++;
		System.out.println("Created Product:" + p.name);
	}

	private void createShopsAndWarehouse(){
		System.out.println("Enter the name of the Shops or Warehouse:\n");
		this.input.nextLine();
		String name = this.input.nextLine();
		if(this.shopsAndWarehouseDetails.containsKey(name) ){
			System.out.println("Shop " + name + " already exists.");
		}
		else createShopsAndWarehouse(name);
		
	}
	private void createShopsAndWarehouse(String name){

		ShopsAndWarehouse s = new ShopsAndWarehouse(name);
		this.shopsAndWarehouseDetails.put(name,s);
		System.out.println("Created Shop: " + s.name);
	}

//////////////////////////////////////////// DELETE ////////////////////////////////////////////

	private void delete(){
		System.out.print("Select The Entity From Which You Want To Delete:(options range:[1,5])\n"+
		"1.Manufacturer\n"+
		"2.Customer\n"+
		"3.Product\n"+
		"4.Shops And Warehouse\n");
		int type = 0;
		type = this.input.nextInt();
		switch(type){
			case 1:
				this.DeleteManufacturer();
				break;
			case 2:
				this.DeleteCustomer();
				break;
			case 3:
				this.DeleteProduct();
				break;
			case 4:
				this.DeleteShopsAndWarehouse();
				break;
			default:
			System.out.println("\n\tCouldn't delete entity! Invalid option.\nShould be an integer in range [1, 4]");
			return;
		}
	}

	private void DeleteManufacturer(){
		System.out.print("Enter the name of the Manufacturer which you wish to delete from the given options : \n");
		printManufacturer();
		this.input.nextLine();
		String name = this.input.nextLine();
		if(!manufacturerDetails.containsKey(name)){
			System.out.print("Invaid Manufacturer name.\n");
		}
		else{
			for(String p : manufacturerDetails.get(name).products){
				this.productDetails.get(p).manufacturerName = null;
			}
			manufacturerDetails.remove(name);
		}

	}
	private void DeleteCustomer(){
		System.out.print("Enter the name of the Customer which you wish to delete from the given options : \n");
		printCustomer();
		this.input.nextLine();
		String name = this.input.nextLine();
		if(!customerDetails.containsKey(name)){
			System.out.print("Invaid Customer name.\n");
		}
		else{
			customerDetails.remove(name);
		}

	}
	private void DeleteProduct(){
		System.out.print("Enter the name of the Product which you wish to delete from the given options : \n");
		printProduct();
		this.input.nextLine();
		String name = this.input.nextLine();
		if(!productDetails.containsKey(name)){
			System.out.print("Invaid Product name.\n");
		}
		else{
			String m = productDetails.get(name).manufacturerName;
			if(m != null){
				manufacturerDetails.get(m).products.remove(name);
			}
			productDetails.remove(name);
		}

	}
	private void DeleteShopsAndWarehouse(){
		System.out.print("Enter the name of the ShopsAndWarehouse which you wish to delete from the given options : \n");
		printShopsAndWarehouse();
		this.input.nextLine();
		String name = this.input.nextLine();
		if(!shopsAndWarehouseDetails.containsKey(name)){
			System.out.print("Invaid ShopsAndWarehouse name.\n");
		}
		else{
			shopsAndWarehouseDetails.remove(name);
		}

	}

//////////////////////////////////////////// PRINT ////////////////////////////////////////////

	private void print(){
		System.out.print("Select The Entity Which You Want To Print:(options range:[1,5])\n"+
		"1.Manufacturer\n"+
		"2.Customer\n"+
		"3.Product\n"+
		"4.Shops And Warehouse\n\n");
		int type = 0;
		type = this.input.nextInt();
		switch(type){
			case 1:
				this.printManufacturer();
				break;
			case 2:
				this.printCustomer();
				break;
			case 3:
				this.printProduct();
				break;
			case 4:
				this.printShopsAndWarehouse();
				break;
			default:
			System.out.println("\n\tCouldn't print entity! Invalid option.\nShould be an integer in range [1, 4]");
			return;
		}
	}

	public void printManufacturer(){
			System.out.println("List of Manufacturers :\n");
			this.manufacturerDetails.forEach((key, value) -> System.out.println(key));
	}
	public void printCustomer(){
			System.out.println("List of Customers :\n");
			this.customerDetails.forEach((key, value) -> System.out.println(key));
	}
	public void printProduct(){
			System.out.println("List of Products :\n");
			this.productDetails.forEach((key, value) -> System.out.println(key));
	}
	public void printShopsAndWarehouse(){
			System.out.println("List of ShopsAndWarehouses :\n");
			this.shopsAndWarehouseDetails.forEach((key, value) -> System.out.println(key));
	}

/////////////////////// ADD PRODUCT TO MANUFACTURER ///////////////////////  
	
	private void addProductToManufacturer(){
		System.out.println("Enter the name of the Product which you wish to add from the given list : \n");
		printProduct();
		String name = this.input.nextLine();
		if(!this.productDetails.containsKey(name)){
			System.out.println("Product " + name + " doesn't exist.\n");	
			return;
		}
		System.out.println("Enter the name of the Manufacturer from the given list : \n");
		printManufacturer();
		String manufacturerName = this.input.nextLine();
		if(!this.manufacturerDetails.containsKey(manufacturerName)){
			System.out.println("Manufacturer " + manufacturerName + " doesn't exist.\n");	
			return;
		}
		else{
			if(this.productDetails.get(name).manufacturerName == null){
				this.productDetails.get(name).manufacturerName = manufacturerName;
				this.manufacturerDetails.get(manufacturerName).products.add(name);
				System.out.println("Added Product " + name + " to Manufacturer " + manufacturerName);
			}
			else{

				System.out.println("Product " + name + " already has Manufacturer " + this.productDetails.get(name).manufacturerName);
			}
		}
	}
/////////////////////// ADD A CERTAIN NUMBER OF COPIES OF A PRODUCT TO A SHOP ///////////////////////
	private void addProductToShop(){

		System.out.println("Enter the name of the Shop from the given list :\n");
		printShopsAndWarehouse();
		String shopName = this.input.nextLine();
		if(!this.shopsAndWarehouseDetails.containsKey(shopName)){
			System.out.println("Invalid ShopAndWarehouse Name.\n");
		}

		else{
			System.out.println("Enter the name of the Product :\n");
			String productName = this.input.nextLine();
			if(!this.productDetails.containsKey(productName)){
				System.out.println("Invalid Product Name.\n");
			}
			else{
				System.out.println("Enter the quantity to be added :\n");
				int quantity = this.input.nextInt();
				if(this.shopsAndWarehouseDetails.get(shopName).productAndQuantity.containsKey(productName)){
					int t = this.shopsAndWarehouseDetails.get(shopName).productAndQuantity.get(productName);
					t += quantity;
					this.shopsAndWarehouseDetails.get(shopName).productAndQuantity.put(productName,t);  
				
				}
				else{ 
					this.shopsAndWarehouseDetails.get(shopName).productAndQuantity.put(productName,quantity);  
				}
			}
		}	
	}

/////////////////////// ADD AN ORDER ///////////////////////

	private void addAnOrder(){
		System.out.println("Enter Customer Name from the list :\n");
		this.printCustomer();
		System.out.println("\n->");
		String customerName = this.input.nextLine();
		if(!this.customerDetails.containsKey(customerName)){
			System.out.println("Invalid Customer Name.\n");
		}else{
			System.out.println("Enter the shop name from the list :\n");
			printShopsAndWarehouse();
			System.out.println("\n->");
			String shopName = this.input.nextLine();
			if(!this.shopsAndWarehouseDetails.containsKey(shopName)){
				System.out.println("Invalid Shop Name.\n");
				return;
			}
			int order_number = customerDetails.get(customerName).order_count++;
			CustomerOrder order = new CustomerOrder(customerName,order_number);
			int type = 1;
			while(type != 0){
				System.out.println("Enter 1 to add a product or 0 to finish order\n");
				type = this.input.nextInt();
				if(type == 1){
					System.out.println("Enter product name from the given list : \n");
					this.input.nextLine();
					String productName = this.input.nextLine();

					System.out.println("Enter product quantity: \n");
					int quantity = this.input.nextInt();
					order.productAndQuantity.put(productName,quantity);
					this.customerDetails.get(customerName).purchases.put(productName,quantity);
				}
			}
			System.out.println("Order : \n");
			order.productAndQuantity.forEach((key, value) -> System.out.println(key+" - "+Integer.toString(value)));
		}
	}

	private void listAllPurchasesMadeByCustomer(){
		System.out.println("Enter Customer Name from the list :\n");
		this.printCustomer();
		String customerName = this.input.nextLine();
		if(!this.customerDetails.containsKey(customerName)){
			System.out.println("Invalid Customer Name.\n");
		}else{
			System.out.println("Customer Orders : \n");
			this.customerDetails.get(customerName).purchases.forEach((key, value) -> System.out.println(key + " - " + Integer.toString(value)));
		}
	}

	private void listInventoryOfShop(){
		System.out.println("Enter Shop Name from the list :\n");
		this.printShopsAndWarehouse();
		String shopName = this.input.nextLine();
		if(!this.shopsAndWarehouseDetails.containsKey(shopName)){
			System.out.println("Invalid Shop Name.\n");
		}else{
			System.out.println("Shop Inventory : \n");
			this.shopsAndWarehouseDetails.get(shopName).productAndQuantity.forEach((key, value) -> System.out.println(key + "-" + Integer.toString(value)));
		}
	}

	private void productsMadeByManufacturer(){
		System.out.println("Enter Manufacturer Name from the list :\n");
		this.printManufacturer();
		String manufacturerName = this.input.nextLine();
		if(!this.manufacturerDetails.containsKey(manufacturerName)){
			System.out.println("Invalid Manufacturer Name.\n");
		}else{
			System.out.println("Manufacturer Products : \n");
			for(String p: manufacturerDetails.get(manufacturerName).products){
				System.out.println(p);
			}
		}
	}

	
}


