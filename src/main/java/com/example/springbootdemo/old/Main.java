package com.example.springbootdemo.old;

import com.example.springbootdemo.model.Cat;
import com.example.springbootdemo.model.Email;
import com.example.springbootdemo.model.Student;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws InvocationTargetException, IllegalAccessException, NoSuchMethodException {
        Email e1 = new Email(123L, "john@gmail.com", null);
        Email e2 = new Email(222L, "bob@gmail.com", null);

        //get via instance
        Class e1Class = e1.getClass();
        Class e2Class = e2.getClass();

        System.out.println(e1Class.equals(e2Class));
        System.out.println(e1Class == e2Class);

        // get via class
        Class e3Class = Email.class;
        System.out.println(e1Class.equals(e3Class));
        System.out.println(e2Class == e3Class);

        //Print fields list
        System.out.println("Fields:");
        Field[] allFields = e3Class.getDeclaredFields();
        for (Field f : allFields) {
            System.out.println(f.getName());
        }

        System.out.println("Methods:");
        for (Method m : e3Class.getDeclaredMethods()) {
            String name = m.getName();
            // System.out.println(name);
            if (name.startsWith("testMeVia")) {
                if (m.getParameterTypes().length == 0) {
                    m.invoke(e1, null);
                } else {
                    m.invoke(e1, 3);
                }


            }
        }
        ;


        Cat cat = new Cat();
        cat.setId(123);

        Class<Cat> catClass = Cat.class;

        for (Method m : catClass.getMethods()) {
            if (m.getName().startsWith("set")) {
                String type = m.getParameterTypes()[0].getSimpleName(); // String or Integer (int)
                switch (type) {
                    case "String": {
                        m.invoke(cat, "Murzik");

                        break;
                    }
                    case "int": {
                        m.invoke(cat, (int) (Math.random() * 10));
                        break;
                    }
                    // .... TODO

                    default:
                        System.out.println("Nu such implementation for type:" + type);
                }
            }
        }

        System.out.println(catClass.getMethod("toString", null).invoke(cat, null));

        Method toStr = catClass.getMethod("toString", null);
        boolean isPresent = toStr.isAnnotationPresent(Test123.class);
        if (!isPresent) {
            throw new RuntimeException("Invalid Cat usage");
        }


    }


    static void m2(int x) {
        x *= 2;
        System.out.println(x);
    }
}

class Child1 {
    static int m1() {
        int x = (int) (Math.random() * 100);
        return x;
    }

    public static void main(String[] args) {
        Reflect<Cat> r = new Reflect<>();
        Cat cat = r.map(new Cat());
        System.out.println(cat);
    }
}


class Reflect<T> {
    T map(T t) {
        for (Method m : t.getClass().getMethods()) {
            if (m.getName().startsWith("set")) {
                String type = m.getParameterTypes()[0].getSimpleName(); // String or Integer (int)
                try {
                    switch (type) {
                        case "String": {
                            m.invoke(t, "Unknown");
                            break;
                        }
                        case "int": {
                            m.invoke(t, Integer.MIN_VALUE);
                            break;
                        }

                        // .... TODO

                        default:
                            System.out.println("No such implementation for type:" + type);
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException(e);
                } catch (InvocationTargetException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return t;
    }
}
