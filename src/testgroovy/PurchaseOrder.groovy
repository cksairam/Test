package testgroovy

class PurchaseOrder {
    	Long orderNo
    	String status
	List<OrderLine> orderLineList
	PurchaseOrder(){}
	PurchaseOrder(orderNo,status,orderLineList){
		this.orderNo = orderNo
		this.status = status
		this.orderLineList = orderLineList
	}
	
	String toString() {
		"Order No : ${orderNo} | Status : ${status}"
	}
}
