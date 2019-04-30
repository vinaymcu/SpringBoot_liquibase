package com.concretepage.test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.concretepage.model.Gender;
import org.apache.commons.lang3.StringUtils;
//import org.apache.commons.lang.StringUtils;

public class Test {

	public static final String EXAMPLE_TEST = "raja vinay";

    public static void main(String[] args) {
		List<String> list= new ArrayList<>();
		list.add("vinay");
		list.add("sss");
		list.add("cccc'");
		System.out.println(getEventCode(list));


    }

	public static String getEventCode(List<String> recordTypes) {
		recordTypes.sort(Comparator.naturalOrder());
		return StringUtils.join(recordTypes, ":");
	}

	

}
