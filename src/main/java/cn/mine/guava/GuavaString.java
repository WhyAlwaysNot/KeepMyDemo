package cn.mine.guava;

import com.google.common.base.*;
import com.google.common.collect.Lists;

import java.util.List;

public class GuavaString {

    public static void main(String[] args) {

        List<String> list = Lists.newArrayList("a","b","c");
        Joiner joiner = Joiner.on(":").skipNulls();
        System.out.println(joiner.join("1","2",null,"3"));
        System.out.println(Joiner.on(":").join(list));

        String s = ",foo,bar,,   qux,,";
        System.out.println(Splitter.on(",").trimResults().omitEmptyStrings().split(s));

        System.out.println(CharMatcher.DIGIT.retainFrom("1g2g2g2g"));
        System.out.println(CharMatcher.DIGIT.removeFrom("1a2b2c2d"));
        System.out.println(CharMatcher.WHITESPACE.trimAndCollapseFrom("s aa    a ", '1'));
        System.out.println(CharMatcher.DIGIT.or(CharMatcher.JAVA_LOWER_CASE).retainFrom("S2AKDN1sad"));
        System.out.println(CaseFormat.UPPER_UNDERSCORE.to(CaseFormat.LOWER_CAMEL, "SHAOBIN_CAIYU"));

        byte[] bytes = "123".getBytes(Charsets.UTF_8);
    }
}
