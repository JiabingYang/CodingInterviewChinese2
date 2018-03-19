package com.yjb.cic.java;

/**
 * 单例
 */
public class No02Singleton {

    /**
     * 懒汉
     */
    static class A {
        private static A a;

        private A() {
        }

        public static synchronized A getInstance() {
            if (a == null) {
                a = new A();
            }
            return a;
        }
    }

    /**
     * 饿汉
     */
    static class B {
        private static final B b = new B();

        private B() {
        }

        public static B getInstance() {
            return b;
        }
    }


    /**
     * 双重校验锁
     */
    static class C {
        private static C c; //JDK1.5后不需要volatile

        private C() {
        }

        public static C getInstance() {
            if (c == null) {
                synchronized (C.class) {
                    if (c == null) {
                        c = new C();
                    }
                }
            }
            return c;
        }
    }

    /**
     * 静态内部类
     */
    static class D {
        private static class Holder {
            private static final D D = new D();
        }

        private D() {
        }

        public static D getInstance() {
            return Holder.D;
        }
    }

    /**
     * 枚举1
     */
    enum E {
        INSTANCE;
    }

    /**
     * 枚举2(我自己写的，不一定对)
     */
    static class F {

        private F() {
        }

        public static F getInstance() {
            return Holder.INSTANCE.f;
        }

        private enum Holder {
            INSTANCE;

            private F f;

            Holder() {
                f = new F();
            }
        }
    }
}
