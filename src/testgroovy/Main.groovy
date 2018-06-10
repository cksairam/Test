package testgroovy

class Main {
	
public static void main(String[] args) {
	BufferedReader buf = new BufferedReader(new InputStreamReader(System.in));
	def purchaseOrderList = []
	def userObject;
	ShopDoorManagement s = new ShopDoorManagement()
	
	String fileData = s.readFileContent("C:\\Users\\sairam\\Desktop\\User.xml");
	//fill code here.
	s.loadAllUsers(fileData)
	
	fileData = s.readFileContent("C:\\Users\\sairam\\Desktop\\Item.xml");
	//fill code here.
	s.loadAllItems(fileData)
	
	println "Login:"
	while(true) {
		println "Username:"
		def userName = buf.readLine()
		println "Password:"
		def password = buf.readLine()
		if(s.validateUser(userName, password))
			break
		else
			println "Username or password is wrong!.try again.."
	}
	def total = 0
	def orderLineList = []
	def i=0
	def j=0
	while(true) {
		println "Item id:"
		def itemId = Long.parseLong(buf.readLine())
		def val
		//fill code here.
		val =s.validateItem(itemId)
		def item
		if(val != null) {
			//fill code here.
			item=s.obtainItem(itemId)
			println "Quantity:"
			def quantity = buf.readLine() as int
			//fill code here.
			orderLineList[i]= new OrderLine(item,quantity,s.computeItemPrice(quantity,item))
			i++
		}
		else {
			println "Item with "+itemId+" not found."
		}
		
		println "Do you want to add one more item?(Yes/No)"
		def ch = buf.readLine()
		if(ch.equalsIgnoreCase("No"))
			break;
			
	}
	
	//fill code here.
	purchaseOrderList[j]=new PurchaseOrder(j,"Created",orderLineList)
	println "Order created successfully."
	println "Purchase order "+(j+1)
	println "Order No : "+(j+1)+" | Status : Created"
	
	Double totalprice
	purchaseOrderList.each{pOrder->
		totalprice=s.computeTotalPrice(pOrder)
		pOrder.orderLineList.each{it->
			
			println "Name : "+it.item.name+" | Quantity : "+it.quantity+" | Price : "+it.price.toString()
		}
		println "Total Purchase order: "+totalprice
		}
		

	
	}
}
