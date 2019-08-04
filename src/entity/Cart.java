package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	
	//购买商品属性集合
	private HashMap<Items, Integer> goods;
	
	//购买商品总金额
	private double totalPrice;

	//构造方法
	public Cart() {
		goods = new HashMap<Items,Integer>();
		totalPrice = 0.0;
	}

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	//添加商品的方法
	public boolean addGoodsInCart(Items item,int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item)+number);
		}else{
			goods.put(item, number);
		}
		calTotalPrice();  //每次添加重新计算
		return true;
	}
	
	//删除商品的方法
	public boolean removeGoodsInCart(Items item){
		goods.remove(item);
		calTotalPrice();  //每次删除重新计算
		return true;
	}
	
	//统计购物车的总金额
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> set = goods.keySet();
		for(Items keys: set){
		sum +=	keys.getPrice()*goods.get(keys);
		}
		
//		Set<Items> keys = goods.keySet();    //获取键的集合
//		Iterator<Items> it =keys.iterator(); //获取迭代器对象
//		while(it.hasNext()){
//			Items i = it.next();
//			System.out.println(goods.get(i));
//			sum += i.getPrice()*goods.get(i);
//		}
		
		 this.setTotalPrice(sum);   //计算总金额
		 return this.getTotalPrice();
	}
	
	@Override
	public String toString() {
		return "Cart [goods=" + goods + ", totalPrice=" + totalPrice + "]";
	}
	
}
