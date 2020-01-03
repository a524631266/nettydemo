package com.base;

public class EnumDemo {
    enum Config {
        A("name", "zhangll"),B("age", 10);
        private final String name;
        private final Object value;
        Config(String name, Object value) {
            this.name = name;
            this.value = value;
        }

        public String getName() {
            return name;
        }

        public Object getValue() {
            return value;
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static void main(String[] args) {
        Config a = Config.B;
        System.out.println(a);
    }
}
