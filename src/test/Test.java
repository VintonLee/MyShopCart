package test;

import java.util.Map;
import java.util.Set;

import entity.Cart;
import entity.Items;


public class Test {
public static void main(String[] args) {
		
		//�ȴ���������Ʒ����
		Items i1 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		Items i2 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		Items i3 = new Items(1,"��������Ь","����",200,500,"001.jpg");
		Items i4 = new Items(2,"�����˶�Ь","����",300,500,"002.jpg");
		Cart c = new Cart();
		c.addGoodsInCart(i1, 1);
		c.addGoodsInCart(i2, 2);
		//�ٴι�����������Ь������3˫
		c.addGoodsInCart(i3, 3);
		c.addGoodsInCart(i4, 2);
		
		
		//����������Ʒ�ļ���
		Set<Map.Entry<Items, Integer>> items= c.getGoods().entrySet();
		for(Map.Entry<Items, Integer> obj:items)
		{
			System.out.println(obj);
		}
		
		
		System.out.println("���ﳵ���ܽ�"+c.getTotalPrice());
		
	}
	
}
