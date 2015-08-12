package cn.mine.guava;

import com.google.common.base.Function;
import com.google.common.base.MoreObjects;
import com.google.common.base.Predicate;
import com.google.common.collect.*;

import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map;

class User implements Comparable<User>{
    public long id;
    public String name;

    public User() {
    }

    public User(long id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("id", id)
                .add("name",name)
                .omitNullValues()
                .toString();
    }

    public int compareTo(User other) {
        return ComparisonChain.start().compare(this.id,other.id).result();
    }
}

public class GuavaCollection {

    public static void main(String[] args) {

        //init model
        User user1 = new User(1, "user1");
        User user2 = new User(2, "user2");
        User user3 = new User(3, "user3");
        User user4 = new User(4, "user4");
        User user5 = new User(5, "user5");


        // list
        List<String> list1 = Lists.newArrayList();
        List<String> list2 = ImmutableList.of("1", "2");
        List<String> list3 = ImmutableList.<String>builder().add("1").add("2").build();

        // Map
        Map<Integer, String> map1 = Maps.newHashMap();
        Map<Integer, String> map2 = ImmutableMap.<Integer, String>builder().put(1, "one").put(2, "two").build();
        Map<Integer, String> map3 = ImmutableMap.of(1, "one", 2, "two");


        //Function List->Map
        List<User> list4 = ImmutableList.of(user1, user2, user3, user4, user5);
        Map<Long, User> map4 = Maps.uniqueIndex(list4, new Function<User, Long>() {
            public Long apply(User input) {
                return input.id;
            }
        });

        //Function Map->Map
        Map<Long, String> map5 = Maps.transformValues(map4, new Function<User, String>() {
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
                return input.id != 1;
            }
        }));

        List<User> list7 = ImmutableList.copyOf(list4);


        // Multiset  -> HashMultiset,TreeMultiset,LinkedHashMultiset,ConcurrentHashMultiset,ImmutableMultiset
        Multiset<String> multiset1 = HashMultiset.create();
        multiset1.add("shaobin");
        multiset1.add("shaobin");
        multiset1.add("caiyu");
        multiset1.add("caiyu", 3);
        //System.out.println(multiset1.count("shaobin"));
        //System.out.println(multiset1);


        // SortedMultiset ->TreeMultiset
        SortedMultiset<String> multiset2 = TreeMultiset.create();
        multiset2.addAll(multiset1);
        multiset2 = multiset2.subMultiset("a", BoundType.CLOSED, "d", BoundType.OPEN);

        // Multimap -> HashMultimap,TreeMultimap,ArrayListMultimap
        Multimap<Integer,String> multimap = HashMultimap.create();
        multimap.put(1,"a");
        multimap.put(1,"a");
        multimap.put(1,"b");
        multimap.put(1,"c");
        multimap.put(2,"a");
        multimap.put(2, "d");
        //System.out.println(multimap);
        Collection<String> value = multimap.get(1);
        //System.out.println(value);

        // biMap
        BiMap<Integer,String> userMap = HashBiMap.create();
        userMap.put(1,"user1");
        userMap.put(2, "user2");
        userMap.inverse().put("user3", 3);

        List<String> list8 = Lists.newArrayListWithCapacity(10);
        List<String> list9 = Lists.newArrayListWithExpectedSize(10);

        // MapDifference
        Map<Integer,String> userMap1 = ImmutableMap.of(1, "user1", 2, "user2");
        Map<Integer,String> userMap2 = ImmutableMap.of(1,"user1",3,"user3");
        MapDifference<Integer,String> diff = Maps.difference(userMap1,userMap2);
        diff.entriesInCommon();     //{1=user1}
        diff.entriesOnlyOnLeft();   //{2=user2}
        diff.entriesOnlyOnRight();  //{3=user3}


        List<User> list10 = Lists.newArrayList(list4);
        Collections.sort(list10);
        System.out.println(list10);



    }
}
