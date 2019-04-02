package presentation;

import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;


public class MyTableModel extends DefaultTableModel {
	
	public <T> DefaultTableModel creare (Class myclass, ArrayList <T> lista)
	{
		ArrayList<String> coloane = new ArrayList<String>();
		Field[] fields = myclass.getDeclaredFields();
		for (Field f : fields )
		{	
			coloane.add(f.getName());
			
		}
		DefaultTableModel tableModel = new DefaultTableModel(coloane.toArray(),0);
		for(T e : lista){
			Object[] data = new Object[coloane.size()];
			int k=0;
			for(Field f : e.getClass().getDeclaredFields()){
				f.setAccessible(true);
				Object o;
				try{
					o = f.get(e);
					data[k++]=o;
				}catch(Exception except){
					
				}
			}
			tableModel.addRow(data);
			
		}
		
		return tableModel;
		
	}
	
	
}