package com.xworkz.tv;

import com.xworkz.tv.dao.TVChannelDAO;
import com.xworkz.tv.dao.TVChannelDAOImpl;
import com.xworkz.tv.entity.TVChannel;

public class TVRunner 
{
public static void main(String[] args) {
	TVChannel tv = new TVChannel();
	tv.setChannelId(1);
	tv.setChannelName("Manish Channel");
	tv.setLanguage("Tamil");
	tv.setFree(true);
	tv.setPrice(1000009.22);
	TVChannelDAO dao = new TVChannelDAOImpl();	
	//dao.saveChannel(tv);
	System.out.println("Saved Successfully");
	dao.getChannel();
	System.out.println("fetching data");
	}

}

