package dao;

import java.util.ArrayList;

import entity.Items;


public interface ItemsDAO {
	
	// ������е���Ʒ��Ϣ
	public ArrayList<Items> getAllItems();
	
	// ������Ʒ��Ż����Ʒ����
	public Items getItemsById(int id) ;
	
	//��ȡ��������ǰ������Ʒ��Ϣ
	public ArrayList<Items> getViewList(String list);
}
