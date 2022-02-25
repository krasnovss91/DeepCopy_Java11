import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args){
        List<String> books = new ArrayList<>();
        books.add("Book1");
        books.add("Book2");
        var man = new Man("Ivan", 31, books);

        var newMan = deepCopy(man,Man.class);

        System.out.println(newMan.getName() + " " + newMan.getAge() +" " + newMan.getFavoriteBooks().toString());
    }

    public static <T> T deepCopy(T anObject, Class<T> classInfo) {
        var gson = new GsonBuilder().create();
        var text = gson.toJson(anObject);
        return gson.fromJson(text, classInfo);
    }
}
