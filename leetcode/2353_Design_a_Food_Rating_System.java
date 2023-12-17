class Food implements Comparable<Food>
{
    String name;
    String cuisine;
    int rating;

    Food(String name, String cuisine, int rating)
    {
        this.name = name;
        this.cuisine = cuisine;
        this.rating = rating;
    }

    

    @Override
    public int compareTo(Food other) {
       if(this.rating == other.rating)
       {
           return this.name.compareTo(other.name);
       }
       return Integer.compare(other.rating, this.rating);
    }
}


class FoodRatings {

    HashMap<String,PriorityQueue<Food>> cuisine_queue;
    HashMap<String,Integer> foodToRating;
    HashMap<String,String> foodToCuisine;

    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        
        cuisine_queue = new HashMap<>();
        foodToRating = new HashMap<>();
        foodToCuisine = new HashMap<>();
        
        for(int i=0; i <foods.length; ++i)
        {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            
            
            if(cuisine_queue.containsKey(cuisines[i]))
            {
                cuisine_queue.get(cuisines[i]).add(new Food(foods[i],cuisines[i],ratings[i]));
            }
            else
            {
                cuisine_queue.put(cuisines[i], new PriorityQueue<Food>());
                cuisine_queue.get(cuisines[i]).add(new Food(foods[i],cuisines[i],ratings[i]));
            }
        }


    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        foodToRating.put(food,newRating);
        cuisine_queue.get(cuisine).add(new Food(food,cuisine,newRating));
    }
    
    public String highestRated(String cuisine) {
        
        PriorityQueue<Food> q = cuisine_queue.get(cuisine);
        while(!q.isEmpty())
        {
            Food f = q.peek();
            if(foodToRating.get(f.name) != f.rating)
            {
                q.poll();
                continue;
            }

            return f.name;
        }
        return "";
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */
