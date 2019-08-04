package dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dao.ItemsDAO;
import entity.Items;
import util.DBUtil;


public class ItemsDAOImpl implements ItemsDAO{

	
	// 获得所有的商品信息
	@Override
	public ArrayList<Items> getAllItems() {
		Connection conn =null;
		PreparedStatement ps =null;
		ResultSet rs = null;
		ArrayList<Items> list = new ArrayList<Items>();//商品集合
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from  items;";
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while(rs.next()){
			Items items = new Items();
			items.setId(rs.getInt("id"));
			items.setName(rs.getString("name"));
			items.setCity(rs.getString("city"));
			items.setPrice(rs.getInt("price"));
			items.setNumber(rs.getInt("number"));
			items.setPicture(rs.getString("picture"));
			list.add(items);
			}
		return list;
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (ps != null) {
				try {
					ps.close();
					ps = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}
		
		
	}
	
	/*
	 * // 根据商品编号获得商品资料
	 */
	@Override
	public Items getItemsById(int id) {

		Connection conn =null;
		PreparedStatement ps =null;   //获取数据库对象
		ResultSet rs = null;		 //获取结果集
		ArrayList<Items> list = new ArrayList<Items>();//商品集合
		
		try {
			conn = DBUtil.getConnection();
			String sql = "select * from items where id=?;";
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				Items item = new Items();
				item.setId(rs.getInt("id"));
				item.setName(rs.getString("name"));
				item.setCity(rs.getString("city"));
				item.setNumber(rs.getInt("number"));
				item.setPrice(rs.getInt("price"));
				item.setPicture(rs.getString("picture"));
				return item;
			}else{
				return null;
			}
		
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}finally {
			// 释放数据集对象
			if (rs != null) {
				try {
					rs.close();
					rs = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
			// 释放语句对象
			if (ps != null) {
				try {
					ps.close();
					ps = null;
				} catch (Exception ex) {
					ex.printStackTrace();
				}
			}
		}		
	
	}

	@Override
	public ArrayList<Items> getViewList(String list) {

		System.out.println("list:"+list);
		ArrayList<Items> itemlist = new ArrayList<Items>();
		int iCount=5; //每次返回前五条记录
		if(list!=null&&list.length()>0)
		{
		    String[] arr = list.split(",");
		    System.out.println("arr.length="+arr.length);
		    //如果商品记录大于等于5条
		    if(arr.length>=5)
		    {
		       for(int i=arr.length-1;i>=arr.length-iCount;i--)
		       {
		    	  itemlist.add(getItemsById(Integer.parseInt(arr[i])));  
		       }
		    }
		    else
		    {
		    	for(int i=arr.length-1;i>=0;i--)
		    	{
		    		itemlist.add(getItemsById(Integer.parseInt(arr[i])));
		    	}
		    }
		    return itemlist;
		}
		else
		{
			return null;
		}
		
	
	}

}
