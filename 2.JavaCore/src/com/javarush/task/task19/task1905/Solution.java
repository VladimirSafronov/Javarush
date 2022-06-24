package com.javarush.task.task19.task1905;

import java.util.*;

/* 
Закрепляем адаптер
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {

    }

    public static class DataAdapter implements RowItem {
        private Customer customer;
        private Contact contact;

        public DataAdapter(Customer customer, Contact contact) {
            this.customer = customer;
            this.contact = contact;
        }

        @Override
        public String getCountryCode() {
            String key = "";
            for(String k : countries.keySet()) {
                if(countries.get(k).equals(customer.getCountryName())) {
                    key = k;
                    break;
                }
            }
            return key;
        }

        @Override
        public String getCompany() {
            return customer.getCompanyName();
        }

        @Override
        public String getContactFirstName() {
            String[] name = contact.getName().split(" ");
            return name[name.length - 1];
        }

        @Override
        public String getContactLastName() {
            String[] name = contact.getName().split(",");
            return name[0];
        }

        @Override
        public String getDialString() {
            StringBuilder call = new StringBuilder();
            call.append("callto://+");
            String telephon = contact.getPhoneNumber();
            List<Character> numbers = new ArrayList<>(Arrays.asList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9'));

            for(int i = 0; i < telephon.length(); i++) {
                if(numbers.contains(telephon.charAt(i))) {
                    call.append(telephon.charAt(i));
                }
            }
            return call.toString();
        }
    }

    public static interface RowItem {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        String getDialString();         //For example: callto://+380501234567
    }

    public static interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public static interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example: +38(050)123-45-67 or +3(805)0123-4567 or +380(50)123-4567 or ...
    }
}