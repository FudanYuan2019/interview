package javalearning;

import java.util.*;
import java.util.List;

/**
 * @Author: Jeremy
 * @Date: 2019/6/5 12:20
 */
public class Test {
    public static Test t1 = new Test();

    public Test() {
        System.out.println("blockA");
    }

    static {
        System.out.println("blockB");
    }

    public static void main(String[] args) {
        Test t2 = new Test();
    }
}

class Demo {
    abstract static class Super {
        public static String getType(Collection<?> collection) {
            return "Super:collection";
        }

        public static String getType(List<?> list) {
            return "Super:list";
        }

        public String getType(ArrayList<?> list) {
            return "Super:arrayList";
        }

        public static String getType(Set<?> set) {
            return "Super:set";
        }

        public String getType(HashSet<?> set) {
            return "Super:hashSet";
        }
    }

    static class Sub extends Super {
        public static String getType(Collection<?> collection) {
            return "Sub";
        }
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<>(), new ArrayList<>(), new HashMap<String, String>().values()};
        Super subToSuper = new Sub();
        for (Collection<?> collection : collections) {
            System.out.println(subToSuper.getType(collection));
        }
    }
}


class Demo2 {
    abstract class Super {
        public String getType(Collection<?> collection) {
            return "Super:collection";
        }

        public String getType(List<?> list) {
            return "Super:list";
        }

        public String getType(ArrayList<?> list) {
            return "Super:arrayList";
        }

        public String getType(Set<?> set) {
            return "Super:set";
        }

        public String getType(HashSet<?> set) {
            return "Super:hashSet";
        }
    }

    class Sub extends Demo2.Super {
        @Override
        public String getType(Collection<?> collection) {
            return "Sub";
        }
    }

    public static void main(String[] args) {
        Collection<?>[] collections = {new HashSet<>(), new ArrayList<>(), new HashMap<String, String>().values()};
        Super subToSuper = new Demo2().new Sub();
        for (Collection<?> collection : collections) {
            System.out.println(subToSuper.getType(collection));
        }
    }
}

class Test2 {
    static int x, y;

    static {
        x = 5;
    }

    public static void main(String args[]) {
        x--;
        myMethod();
        System.out.println(x + y + ++x);
    }

    public static void myMethod() {
        y = x++ + ++x;
    }
}
