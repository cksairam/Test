package testgroovy

class ShopDoorManagement {

    public static def userList = []
    public static def itemList = []
	
	def readFileContent(filename) {
		def xmlString
		 File myfile = new File(filename)
			 xmlString =myfile.text
			 return xmlString
		
	}
	
	def loadAllUsers(xmlString) {
		def users = new XmlSlurper().parseText(xmlString)
		def i=0
		users.user.each{user ->
		userList[i]=new User(user.@id.toString().toLong(),user.name.toString(),user.username.toString()
			,user.password.toString(),user.role.toString())
		i++
		}
	}
	
	def loadAllItems(xmlString) {
		def items = new XmlSlurper().parseText(xmlString);
		def i=0
		items.item.each{item ->
		itemList[i]=new Item(item.@id.toString().toLong(),item.name.toString(),item.unitprice.toString().toDouble())
		   i++
		}
	}
	
	boolean validateUser(uname,passwd) {
		boolean val = false
		userList.find{
			if(it.username.equals(uname) && it.password.equals(passwd))
				val = true;}
		return val
	}
	
	def validateItem(itemId) {
		def item
		item=itemList.find{it.id==itemId}
		return item
	}
	
	double computeItemPrice(quantity,item) {
		double price
		
		price=quantity*item.unitPrice
			
		return price
	}
	
	def obtainItem(itemId) {
		def item
		item=itemList.find{it.id==itemId}
		return item
	}
	
	double computeTotalPrice(purchaseOrder) {
		def orderLineList = []
		double price = 0
		//fill code here.
		orderLineList=purchaseOrder.orderLineList
		orderLineList.each{it ->
			price+=it.price
			
		}
		
		return price
	}
	
}
