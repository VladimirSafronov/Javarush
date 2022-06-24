package com.javarush.task.task19.task1903;

import java.util.HashMap;
import java.util.Map;

/* 
Адаптация нескольких интерфейсов
*/

public class Solution {
    public static Map<String, String> countries = new HashMap<String, String>();

    static {
        countries.put("UA", "Ukraine");
        countries.put("RU", "Russia");
        countries.put("CA", "Canada");
    }

    public static void main(String[] args) {
        ClientsDB client = new ClientsDB("RU", "JavaRush Ltd.", "Ivan",
                "Petrov", 38, 501234567);
        System.out.println(client);
        IncomeDataAdapter adapter = new IncomeDataAdapter(client);
        String answerString = "AnswerString \n" +
                "countryCode='" + adapter.getCountryName() + '\'' +
                ", company='" + adapter.getCompanyName() + '\'' +
                ", contactName='" + adapter.getName() + '\'' +
                ", phoneNumber=" + adapter.getPhoneNumber();
        System.out.println(answerString);
    }

    public static class ClientsDB implements IncomeData {
        private String countryCode;
        private String company;
        private String contactFirstName;
        private String contactLastName;
        private int countryPhoneCode;
        private int phoneNumber;

        public ClientsDB(String countryCode, String company, String contactFirstName, String contactLastName, int countryPhoneCode, int phoneNumber) {
            this.countryCode = countryCode;
            this.company = company;
            this.contactFirstName = contactFirstName;
            this.contactLastName = contactLastName;
            this.countryPhoneCode = countryPhoneCode;
            this.phoneNumber = phoneNumber;
        }

        public String getCountryCode() {
            return countryCode;
        }

        public String getCompany() {
            return company;
        }

        public String getContactFirstName() {
            return contactFirstName;
        }

        public String getContactLastName() {
            return contactLastName;
        }

        public int getCountryPhoneCode() {
            return countryPhoneCode;
        }

        public int getPhoneNumber() {
            return phoneNumber;
        }

        @Override
        public String toString() {
            return "ClientsDB \n" +
                    "countryCode='" + countryCode + '\'' +
                    ", company='" + company + '\'' +
                    ", contactFirstName='" + contactFirstName + '\'' +
                    ", contactLastName='" + contactLastName + '\'' +
                    ", countryPhoneCode=" + countryPhoneCode +
                    ", phoneNumber=" + phoneNumber;
        }
    }

    public static class IncomeDataAdapter implements Customer, Contact {
        private IncomeData data;

        public IncomeDataAdapter(IncomeData data) {
            this.data = data;
        }

        @Override
        public String getCompanyName() {
            return data.getCompany();
        }

        @Override
        public String getCountryName() {
            return countries.get(data.getCountryCode());
        }

        @Override
        public String getName() {
            return data.getContactLastName() + ", " + data.getContactFirstName();
        }

        @Override
        public String getPhoneNumber() {
            StringBuilder telephoneNumber = new StringBuilder();

            String telephone = String.valueOf(data.getPhoneNumber());
            int telLength = telephone.length();
            if (!(telLength == 10)) {
                while (telLength < 10) {
                    telephone = "0" + telephone;
                    telLength = telephone.length();
                }
            }
            String firstTelPart = telephone.substring(0, 3);
            String secondTelPart = telephone.substring(3, 6);
            String thirdTelPart = telephone.substring(6, 8);
            String fourthTelPart = telephone.substring(8, 10);

            telephoneNumber.append("+").append(data.getCountryPhoneCode());
            telephoneNumber.append("(").append(firstTelPart).append(")");
            telephoneNumber.append(secondTelPart).append("-").append(thirdTelPart).append("-").append(fourthTelPart);

            return telephoneNumber.toString();
        }
    }


    public interface IncomeData {
        String getCountryCode();        //For example: UA

        String getCompany();            //For example: JavaRush Ltd.

        String getContactFirstName();   //For example: Ivan

        String getContactLastName();    //For example: Ivanov

        int getCountryPhoneCode();      //For example: 38

        int getPhoneNumber();           //For example1: 501234567, For example2: 71112233
    }

    public interface Customer {
        String getCompanyName();        //For example: JavaRush Ltd.

        String getCountryName();        //For example: Ukraine
    }

    public interface Contact {
        String getName();               //For example: Ivanov, Ivan

        String getPhoneNumber();        //For example1: +38(050)123-45-67, For example2: +38(007)111-22-33
    }
}