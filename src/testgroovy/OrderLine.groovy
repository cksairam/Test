package testgroovy

class OrderLine {
    	Item item
    	Integer quantity
	Double price
	
	OrderLine() {}
	
	OrderLine(item,quantity,price) {
		this.item = item
		this.quantity = quantity
		this.price = price
	}
	
	String toString() {
		"Name : ${item.name} | Quantity : ${quantity} | Price : ${price}"
	}
}
