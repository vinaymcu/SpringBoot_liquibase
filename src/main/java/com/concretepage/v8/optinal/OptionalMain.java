package com.concretepage.v8.optinal;

import java.util.Optional;

public class OptionalMain {
    public static void main(String args[]){

        Optional<String> gender = Optional.of("male");
        System.out.println("gender::"+gender+"--"+gender.get()+"-"+gender.isPresent());
        System.out.println("Empty Optional: " + Optional.empty());
        System.out.println("Non-Empty Optional:: " + gender.map(String::toUpperCase));

        Optional<String> emptyGender = Optional.empty();
        System.out.println("Empty Optional    :: " + emptyGender.map(String::toUpperCase));

        ScreenResolution resolution = new ScreenResolution(750,1334);

        DisplayFeatures dfeatures = new DisplayFeatures("4.7", Optional.of(resolution));
        Mobile mobile = new Mobile(2015001, "Apple", "iPhone 6s", Optional.of(dfeatures));
        System.out.println(OptionalMain.getMobileScreenWidth(Optional.of(mobile)));

        Mobile mobile2 = new Mobile(2015001, "Apple", "iPhone 6s", Optional.empty());
        System.out.println(OptionalMain.getMobileScreenWidth(Optional.of(mobile2)));


    }

//    public static int getMobileScreenWidth(Mobile mobile){
//
//        if(mobile != null){
//            DisplayFeatures dfeatures = mobile.getDisplayFeatures();
//            if(dfeatures != null){
//                ScreenResolution resolution = dfeatures.getResolution();
//                if(resolution != null){
//                    return resolution.getWidth();
//                }
//            }
//        }
//        return 0;
//    }

    public static Integer getMobileScreenWidth(Optional<Mobile> mobile){
        return mobile.flatMap(Mobile::getDisplayFeatures)
                .flatMap(DisplayFeatures::getResolution)
                .map(ScreenResolution::getWidth)
                .orElse(0);

    }

}
