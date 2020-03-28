
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Order {
	
	public ArrayList<String> placeOrder(ArrayList<String> orders){
		ArrayList<String> orderWithPrice = new ArrayList<String>();
		for (String order : orders) {
			if(order.contains(",")){
				String[] split = order.split(",");
				if(getMenuItem().containsKey(split[0])){
					Float price = getMenuItem().get(split[0]);
					for (int i = 1; i < split.length; i++) {
						if(split[i].contains("-")){
							Float float1 = getingredientprice().get(split[i].replace("-", ""));
							price = price-float1;
						}
					}
					orderWithPrice.add("Item : "+ split[0] +" Price : "+price);
				}
			}else{
				Float price = getMenuItem().get(order);
				orderWithPrice.add("Item : "+ order +" Price : "+price);
			}
		}
		
		return orderWithPrice;
	}
	
	private Map<String,Float> getMenuItem(){
		HashMap<String, Float> menuMap = new HashMap<String, Float>();
		menuMap.put("Coffee",5f);
		menuMap.put("Chai",4f);
		menuMap.put("Banana Smoothie",6f);
		menuMap.put("Strawberry Shake",7f);
		menuMap.put("Mojito",7.5f);
		return menuMap;
	}
	private Map<String,Float> getingredientprice(){
		HashMap<String, Float> menuMap = new HashMap<String, Float>();
		menuMap.put("milk",1f);
		menuMap.put("sugar",0.5f);
		menuMap.put("soda",0.5f);
		menuMap.put("mint",0.5f);
		menuMap.put("water",0.5f);
		return menuMap;
	}
	public static void main(String[] args) {
		ArrayList<String> al = new ArrayList<>();
		al.add("Chai,-sugar");
		al.add("Chai");
		al.add("Chai,-sugar,-milk");
		al.add("Coffee,-sugar,-milk");
		
		Order o = new Order();
		ArrayList<String> placeOrder = o.placeOrder(al);
		
		for (String string : placeOrder) {
			System.out.println(string);		
		}
		
		
	}

	
}
