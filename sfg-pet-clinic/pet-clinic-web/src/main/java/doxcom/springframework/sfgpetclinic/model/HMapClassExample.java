package doxcom.springframework.sfgpetclinic.model;

import java.util.HashMap;
import java.util.Map;

public class HMapClassExample <T extends BaseEntity, ID extends Long> {

    Map<Long, T> hmap2 = new HashMap<>(); //T is an object that extends from base Entity
    public static void main(String[] args) {
        HashMap<String, Integer> hmap = new HashMap<>();

        hmap.put("Last Resort",139993);
        System.out.println(hmap.get("Last Resort"));

    }


}
