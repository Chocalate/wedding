package test;

/**
 * @Author: Lily
 * @Description: //TODO
 * @Date: 2021-03-23 21:55
 **/

public class Demo {
        public static void main(String[] args){
            Person p = new Person("阿大");
            change(p);
            System.out.println(p.name);
        }

        public static void change(Person p) {
            Person person = new Person("阿小");
            p.name = "阿小";
        }
    }
    class Person {
        String name;
        public Person(String name) {
            this.name = name;
        }
}

