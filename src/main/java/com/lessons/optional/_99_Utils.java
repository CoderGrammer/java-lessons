package com.lessons.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.With;

import java.util.List;
import java.util.Optional;
import java.util.function.UnaryOperator;

public class _99_Utils {

    public static void print(Object s) {
        System.out.println(s);
    }

    public static class Skill {

        String name;

        Integer years;

        public Optional<Integer> getYears() {
            return Optional.ofNullable(years);
        }

        public String getName() {
            return name;
        }
    }

    @EqualsAndHashCode
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Employee {

        @Getter
        int id;

        Skill skill;

        Integer getYrsOfService() {
            return 1;
        }

        Optional<Integer> getAge() {
            return Optional.of(1);
        }

        Optional<String> getMiddleName() {
            return Optional.of("Smith");
        }

        public Optional<Skill> getSkill() {
            return Optional.ofNullable(skill);
        }
    }

    @With
    @Data
    @AllArgsConstructor
    public static class Car {
        long mileage;
        Engine engine;
    }

    @Data
    public static class Engine {
        String size;
    }

    @Data
    public static class SearchResultSet {
        List<Car> cars;
        Car bestMatch;

        Optional<Car> mapBestMatch(UnaryOperator<Car> func) {
            if (bestMatch == null) {
                return Optional.empty();
            }
            return Optional.of(func.apply(bestMatch));
        }

    }

}
