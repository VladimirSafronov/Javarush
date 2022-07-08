package com.javarush.task.task20.task2016;

/*
Минимум изменений
*/

import java.io.Serializable;

public class Solution {
    public class A implements Serializable {
        String name = "A";

        public A(String name) {
            this.name += name;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public class B extends A {
        String name = "B";

        public B(String name) {
            super(name);
            this.name += name;
        }
    }

    public class C extends B {
        String name = "C";

        public C(String name) {
            super(name);
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Solution.A a = new Solution().new A("1");
        System.out.println(a);

        Solution.B b = new Solution().new B("2");
        System.out.println(b);

        Solution obj = new Solution();
        C c = obj.new C("3");
        System.out.println(c);
    }
}
