package entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Cart {
	
	//������Ʒ���Լ���
	private HashMap<Items, Integer> goods;
	
	//������Ʒ�ܽ��
	private double totalPrice;

	//���췽��
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
	
	//�����Ʒ�ķ���
	public boolean addGoodsInCart(Items item,int number){
		if(goods.containsKey(item)){
			goods.put(item, goods.get(item)+number);
		}else{
			goods.put(item, number);
		}
		calTotalPrice();  //ÿ��������¼���
		return true;
	}
	
	//ɾ����Ʒ�ķ���
	public boolean removeGoodsInCart(Items item){
		goods.remove(item);
		calTotalPrice();  //ÿ��ɾ�����¼���
		return true;
	}
	
	//ͳ�ƹ��ﳵ���ܽ��
	public double calTotalPrice(){
		double sum = 0.0;
		Set<Items> set = goods.keySet();
		for(Items keys: set){
		sum +=	keys.getPrice()*goods.get(keys);
		}
		
//		Set<Items> keys = goods.keySet();    //��ȡ���ļ���
//		Iterator<Items> it =keys.iterator(); //��ȡ����������
//		while(it.hasNext()){
//			Items i = it.next();
//			System.out.println(goods.get(i));
//			sum += i.getPrice()*goods.get(i);
//		}
		
		 this.setTotalPrice(sum);   //�����ܽ��
		 return this.getTotalPrice();
	}
	
	@Override
	public String toString() {
		return "Cart [goods=" + goods + ", totalPrice=" + totalPrice + "]";
	}
	
}
