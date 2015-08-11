package cn.mine.guava;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.List;
import java.util.Map;

class User{
    public long id;
    public String name;

    public User() {
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class GuavaCollection {

    public static void main(String[] args) {

        //init model
        User user1 = new User(1,"user1");
        User user2 = new User(2,"user2");
        User user3 = new User(3,"user3");
        User user4 = new User(4,"user4");
        User user5 = new User(5,"user5");


        // list
        List<String> list1 = Lists.newArrayList();
        List<String> list2 = ImmutableList.of("1", "2");
        List<String> list3 = ImmutableList.<String>builder().add("1").add("2").build();

        // Map
        Map<Integer,String> map1 = Maps.newHashMap();
        Map<Integer,String> map2 = ImmutableMap.<Integer,String>builder().put(1,"one").put(2,"two").build();
        Map<Integer,String> map3 = ImmutableMap.of(1, "one", 2, "two");



        //Function List->Map
        List<User> list4 = ImmutableList.of(user1,user2,user3,user4,user5);
        Map<Long,User> map4 = Maps.uniqueIndex(list4, new Function<User, Long>() {
            public Long apply(User input) {
                return input.id;
            }
        });

        //Function Map->Map
        Map<Long,String> map5 = Maps.transformValues(map4, new Function<User, String>() {
            public String apply(User input) {
                return input.name;
            }
        });

        //Function List->List
        List<String> list5 = Lists.transform(list4, new Function<User, String>() {
            public String apply(User input) {
                return input.name;
            }
        });

        // Predicate 做筛选用的
        List<User> list6 = Lists.newArrayList(Collections2.filter(list4, new Predicate<User>() {
            public boolean apply(User input) {
                return input.id!=1;
            }
        }));


    }
}
